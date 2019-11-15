package com.sunyoung.Spring1010;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class selectTest {
	public static void main(String[] args) {
		String maxYear= "";
		int nextYear = 0; 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버 생성 실패");
		}
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String url = "jdbc:oracle:thin:@192.168.110.112:1521:orcl";
		try {
			conn = DriverManager.getConnection(url, "KOPO", "kopo");

		
			String query = "select*from" + 
					"(select yearweek" + 
					" from kopo_product_volume a order by a.yearweek DESC)b where rownum=1";
			System.out.println(query);
			stmt = conn.prepareStatement(query);

			// 쿼리를 실행해 결과 rs에 담아 리턴
			rs = stmt.executeQuery();
			while (rs.next()) {
			maxYear = rs.getString("yearweek");
			}
			
			nextYear = Integer.parseInt(maxYear.substring(0,4))+1;
			System.out.println(nextYear);
			

			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("쉴퐤!"+e);
		}

		
	}

}
