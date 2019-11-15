package com.sunyoung.Spring1010;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	ApplicationContext context =new GenericXmlApplicationContext("config/beans.xml");
	DataSource ds = (DataSource) context.getBean("dataSource");
	String maxWeek = "";
	String maxYear = "";
	String nextYear = "";
	String yearWeek = "";
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;


	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		return "insert";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Locale locale, Model model) {

		return "list";
	}


	@RequestMapping(value = "/list_index", method = RequestMethod.GET)
	public @ResponseBody ArrayList<HashMap> userList(Locale locale, Model model) {
		ArrayList<HashMap> data = new ArrayList<HashMap>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버 생성 실패");
		}
		
		try {
			conn = ds.getConnection();

			String query = "SELECT * FROM NEW_KOPO_DATA ORDER BY REGIONID, PRODUCTGROUP,YEARWEEK ASC";
			System.out.println("쿼리야 찍혀봐!" + query);
			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();

			while (rs.next()) {
				System.out.println();
				String regionid = rs.getString("REGIONID");
				String productgroup = rs.getString("PRODUCTGROUP");
				String yearweek = rs.getString("YEARWEEK");
				int volume = rs.getInt("VOLUME");
				HashMap<String, String> row = new HashMap<String, String>();
				row.put("regionid",regionid);
				row.put("productgroup", productgroup);
				row.put("yearweek", yearweek);
				row.put("volume", volume + "");
				data.add(row);
				System.out.println("로우로우"+row);
			}
			stmt.close();
			conn.close();
		} catch (Exception e) {

		}

		return data;
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public @ResponseBody HashMap<String, String> listInsert(Locale locale, Model model) {
		PostWeek test = new PostWeek();
		
		HashMap<String, String> result = new HashMap<String, String>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버 생성 실패");
		}
		
		try {
			conn = ds.getConnection();

			String query = "select*from" + "(select yearweek"
					+ " from kopo_product_volume a order by a.yearweek DESC)b where rownum=1";
			System.out.println("쿼리야 찍혀봐!" + query);
			stmt = conn.prepareStatement(query);

			rs = stmt.executeQuery();
			while (rs.next()) {
				maxYear = rs.getString("yearweek");
			}
			nextYear = (Integer.parseInt(maxYear.substring(0, 4)) + 1) + "";
			System.out.println("2017모여라" + nextYear);

			maxWeek = test.postWeek(nextYear + "");
			System.out.println("2017마지막주는?" + maxWeek);

			for (int i = 1; i <= Integer.parseInt(maxWeek); i++) {
				if (i < 10) {
					yearWeek = nextYear + '0' + i;
					String insertQuery = "INSERT INTO NEW_KOPO_DATA (REGIONID,PRODUCTGROUP,YEARWEEK,VOLUME) VALUES ('A01','ST0001','"
							+ yearWeek + "',0)";
					System.out.println(insertQuery);
					stmt = conn.prepareStatement(insertQuery);
					rs = stmt.executeQuery();

				} else {
					yearWeek = nextYear + i;

					String insertQuery = "INSERT INTO NEW_KOPO_DATA (REGIONID,PRODUCTGROUP,YEARWEEK,VOLUME) VALUES ('A01','ST0001','"
							+ yearWeek + "',0)";
					System.out.println(insertQuery);
					stmt = conn.prepareStatement(insertQuery);
					rs = stmt.executeQuery();
				}
			}

			for (int i = 1; i <= Integer.parseInt(maxWeek); i++) {
				if (i < 10) {
					yearWeek = nextYear + '0' + i;
					String insertQuery2 = "INSERT INTO NEW_KOPO_DATA (REGIONID,PRODUCTGROUP,YEARWEEK,VOLUME) VALUES ('A01','ST0001','"
							+ yearWeek + "',0)";
					System.out.println(insertQuery2);
					stmt = conn.prepareStatement(insertQuery2);
					rs = stmt.executeQuery();
				} else {
					yearWeek = nextYear + i;

					String insertQuery2 = "INSERT INTO NEW_KOPO_DATA (REGIONID,PRODUCTGROUP,YEARWEEK,VOLUME) VALUES ('A01','ST0002','"
							+ yearWeek + "',0)";
					System.out.println(insertQuery2);
					stmt = conn.prepareStatement(insertQuery2);
					rs = stmt.executeQuery();
				}
			}

			stmt.close();
			conn.close();
		} catch (Exception e) {

		}
		result.put("result", "success");
		return result;

	}
	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public @ResponseBody HashMap<String, String> listInput(Locale locale, Model model,@RequestParam String regionid) {
		PostWeek test = new PostWeek();
		
		HashMap<String, String> result = new HashMap<String, String>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버 생성 실패");
		}
		
		try {
			conn = ds.getConnection();

			String query = "select*from" + "(select yearweek"
					+ " from kopo_product_volume a order by a.yearweek DESC)b where rownum=1";
			System.out.println("쿼리야 찍혀봐!" + query);
			stmt = conn.prepareStatement(query);

			rs = stmt.executeQuery();
			while (rs.next()) {
				maxYear = rs.getString("yearweek");
			}
			nextYear = (Integer.parseInt(maxYear.substring(0, 4)) + 1) + "";
			System.out.println("2017모여라" + nextYear);

			maxWeek = test.postWeek(nextYear + "");
			System.out.println("2017마지막주는?" + maxWeek);

			for (int i = 1; i <= Integer.parseInt(maxWeek); i++) {
				if (i < 10) {
					yearWeek = nextYear + '0' + i;
					String insertQuery = "INSERT INTO NEW_KOPO_DATA (REGIONID,PRODUCTGROUP,YEARWEEK,VOLUME) VALUES ('"+regionid+"','ST0001','"
							+ yearWeek + "',0)";
					System.out.println(insertQuery);
					stmt = conn.prepareStatement(insertQuery);
					rs = stmt.executeQuery();

				} else {
					yearWeek = nextYear + i;

					String insertQuery = "INSERT INTO NEW_KOPO_DATA (REGIONID,PRODUCTGROUP,YEARWEEK,VOLUME) VALUES ('"+ regionid+ "','ST0001','"
							+ yearWeek + "',0)";
					System.out.println(insertQuery);
					stmt = conn.prepareStatement(insertQuery);
					rs = stmt.executeQuery();
				}
			}

			for (int i = 1; i <= Integer.parseInt(maxWeek); i++) {
				if (i < 10) {
					yearWeek = nextYear + '0' + i;
					String insertQuery2 = "INSERT INTO NEW_KOPO_DATA (REGIONID,PRODUCTGROUP,YEARWEEK,VOLUME) VALUES ('" + regionid + "','ST0001','"
							+ yearWeek + "',0)";
					System.out.println(insertQuery2);
					stmt = conn.prepareStatement(insertQuery2);
					rs = stmt.executeQuery();
				} else {
					yearWeek = nextYear + i;

					String insertQuery2 = "INSERT INTO NEW_KOPO_DATA (REGIONID,PRODUCTGROUP,YEARWEEK,VOLUME) VALUES ('"+ regionid+ "','ST0002','"
							+ yearWeek + "',0)";
					System.out.println(insertQuery2);
					stmt = conn.prepareStatement(insertQuery2);
					rs = stmt.executeQuery();
				}
			}

			stmt.close();
			conn.close();
		} catch (Exception e) {

		}
		result.put("result", "success");
		return result;

	}

}
