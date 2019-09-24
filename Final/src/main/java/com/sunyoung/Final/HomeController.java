package com.sunyoung.Final;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.sqlite.SQLiteConfig;

import com.sunyoung.Final.DBCommon;
import com.sunyoung.Final.Student;
//import com.sunyoung.Final.DataReader;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model,HttpServletRequest request) {
		if (request.getParameter("name") == null) {
			DBCommon<Student> dbCommon = new DBCommon<Student>("c:\\tomcat\\student2.sqlite", "studentScore");
			model.addAttribute("select_result", dbCommon.selectDataTableTag(new Student()));
		} else {
			String name = (String) request.getParameter("name");
			DBCommon<Student> dbCommon = new DBCommon<Student>("c:\\tomcat\\student2.sqlite", "studentScore");
			model.addAttribute("select_result", dbCommon.searchDataTableTag(new Student(), "name", name));
		}
	
		return "list";
	}
	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public String input(Locale locale, Model model) {
		return "input";
	}
	
	@RequestMapping(value = "/inputData", method = RequestMethod.GET)
	public String inputData(@RequestParam("name") String name,@RequestParam("middleScore") int middleScore,@RequestParam("finalScore") int finalScore) {
		
		DBCommon<Student> dbCommon = new DBCommon<Student>("c:\\tomcat\\student2.sqlite", "studentScore");
		dbCommon.insertData(new Student(name,middleScore,finalScore));
		return "done";
	}
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String update(Locale locale, Model model, @RequestParam("idx") int idx) {
		DBCommon<Student> dbCommon = new DBCommon<Student>("c:\\tomcat\\student2.sqlite", "studentScore");
		HashMap<String, String> userData = dbCommon.detailsData(new Student(), idx);
		if (userData != null) {
			model.addAttribute("idx_value", userData.get("idx"));
			model.addAttribute("name_value", userData.get("name"));
			model.addAttribute("middleScore_value", userData.get("middleScore"));
			model.addAttribute("finalScore_value", userData.get("finalScore"));
		}
	
	
		return "update";
	}
	
	@RequestMapping(value = "/updateData", method = RequestMethod.GET)
	public String updateData(@RequestParam("idx") int idx, @RequestParam("name") String name, @RequestParam("middleScore") int middleScore, @RequestParam("finalScore") int finalScore) {
	
		DBCommon<Student> dbCommon = new DBCommon<Student>("c:\\tomcat\\student2.sqlite", "studentScore");
		dbCommon.updateData(new Student(name, middleScore, finalScore), idx);
		
		return "done";
	}
	
	@RequestMapping(value = "/create_table", method = RequestMethod.GET)
	public String createTable(Locale locale, Model model) {
		DBCommon<Student> dbCommon = new DBCommon<Student>("c:\\tomcat\\student2.sqlite", "studentScore");
		dbCommon.createTable(new Student());
		return "done";
	}
	
	@RequestMapping(value = "/done", method = RequestMethod.GET)
	public String done(Locale locale, Model model) {
		return "done";
	}
	@RequestMapping(value = "/search_data", method = RequestMethod.GET)
	public String searchData(Locale locale, Model model, @RequestParam("name") String name) {
//		DBCommon<Student> dbCommon = new DBCommon<Student>("c:\\tomcat\\student190624.sqlite", "student190624");
//		model.addAttribute("select_result", dbCommon.searchDataTableTag(new Student(), "name", name));
//		System.out.println("�˻���) "+name);
		
		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			connection = DriverManager.getConnection("jdbc:sqlite:/c:\\tomcat\\student2.sqlite", config.toProperties());

			String query = "SELECT * FROM studentScore WHERE name LIKE '%" + name + "%'";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			StringBuilder htmlString = new StringBuilder();
			while (resultSet.next()) {
				htmlString.append("<tr>");
				String fieldName = resultSet.getString("name");
				int idx = resultSet.getInt("idx");
				int middleScore = resultSet.getInt("middleScore");
				int finalScore = resultSet.getInt("finalScore");
				htmlString.append("<td>" + idx + "</td>");
				htmlString.append("<td>" + fieldName + "</td>");
				htmlString.append("<td>" + middleScore + "</td>");
				htmlString.append("<td>" + finalScore + "</td>");
				htmlString.append("</tr>");
			}
			model.addAttribute("select_result", htmlString);
			preparedStatement.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		connection = null;
		
		return "list";
	}

	
	

	
}
