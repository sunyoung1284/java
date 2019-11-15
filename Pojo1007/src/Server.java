import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Server implements Runnable {
	Socket client;

	Server(Socket client) {
		this.client = client;
	}

	public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
		ServerSocket server = new ServerSocket(9000);
		System.out.println("Listening");

		while (true) {
			Socket client = server.accept();
			System.out.println("Connected");
			new Thread(new Server(client)).start();
		}
	}

	public void run() {
		InputStream in = null;
		OutputStream out = null;

		try

		{
			System.out.println("Server has started on 127.0.0.1:9000.\r\nWaiting for a connection...");
			System.out.println("A client connected.");
			in = client.getInputStream();
			out = client.getOutputStream();
			Scanner s = new Scanner(in, "UTF-8");
			try {
				String data = s.useDelimiter("\\r\\n\\r\\n").next();
				Matcher get = Pattern.compile("^GET").matcher(data);
				System.out.println("나는데이터야" + data);
				if (get.find()) {
					Matcher match = Pattern.compile("regionid(.*)").matcher(data);
					match.find();
					System.out.println("나는 매치매치 " + match.group());
					
					String queryResult = "";
					// 1. 오라클 드라이버 생성
					try {
						Class.forName("oracle.jdbc.driver.OracleDriver");
					} catch (ClassNotFoundException e) {
						System.out.println("오라클 드라이버 생성 실패");
					}

					// 2. 오라클 인스턴스 객체 생성
					Connection conn = null;
					PreparedStatement stmt = null;
					ResultSet rs = null;

					// 3. 오라클 인스턴스 생성
					String url = "jdbc:oracle:thin:@localhost:1522:XE";

					try {
						conn = DriverManager.getConnection(url, "SY2019", "sy2019");

						// 4. 쿼리 실행
						String query = "SELECT * FROM KOPO_PRODUCT_VOLUME WHERE REGIONID ='"
								+ (match.group().split(" ")[0]).split("=")[1] + "'";

						// 자바에서 쿼리 실행할 수 있는 stmt 객체 생성
						stmt = conn.prepareStatement(query);

						// 5. 쿼리를 실행해 결과 rs에 담아 리턴
						rs = stmt.executeQuery();

						queryResult = "[";
						while (rs.next()) {
							String regionid = rs.getString("REGIONID");
							String productgroup = rs.getString("PRODUCTGROUP");
							String yearweek = rs.getString("YEARWEEK");
							int volume = rs.getInt("VOLUME");
							queryResult += "{REGIONID : ";
							queryResult += regionid + ", ";
							queryResult += "PRODUCTGROUP : ";
							queryResult += productgroup + ", ";
							queryResult += "YEARWEEK : ";
							queryResult += yearweek + ", ";
							queryResult += "VOLUME : ";
							queryResult += volume + "},";

						}
						queryResult = queryResult.substring(0, queryResult.length() - 1);
						queryResult += "]";
						System.out.println(queryResult);

					} catch (SQLException e) {

					} finally {
						if (rs != null) {
							try {
								rs.close();
							} catch (SQLException e) {
							}
						}
						if (stmt != null) {
							try {
								stmt.close();
							} catch (SQLException e) {
							}
						}
						if (conn != null) {
							try {
								conn.close();
							} catch (SQLException e) {
							}
						}
					}
					String response = "HTTP/1.1 200 OK \r\n\r\n" + queryResult;
					out.write(response.getBytes("UTF-8"));
				}
			} finally {
				s.close();
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			

		}
	}
}
