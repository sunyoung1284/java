package com.sunyoung.Spring0905;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.sqlite.SQLiteConfig;

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
	public String home(Locale locale, Model model) {

		return "login";
	}
	@RequestMapping(value = "/sign_up", method = RequestMethod.GET)
	public String signUp(Locale locale, Model model) {

		return "signup";
	}
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Locale locale, Model model,HttpServletRequest request) {
		HttpSession session = request.getSession();
		Boolean isLogin = (Boolean) session.getAttribute("is_login");
		if(isLogin == null || !isLogin) {
			return "redirect:/";
		}
		return "list";
	}
	
	@RequestMapping(value = "/list_index", method = RequestMethod.GET)
	public @ResponseBody ArrayList<HashMap> userList(Locale locale, Model model) {
		Connection connection = null;
		ArrayList<HashMap> data = new ArrayList<HashMap>();
		try {
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			connection = DriverManager.getConnection("jdbc:sqlite:/c:\\tomcat\\sunyoung.db", config.toProperties());

			String query = "SELECT * FROM list"; // name LIKE '%" + name + "%'
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int idx = resultSet.getInt("idx");
				String title = resultSet.getString("title");
				String description = resultSet.getString("description");
				HashMap<String, String> row = new HashMap<String, String>();
				row.put("idx", "" + idx);
				row.put("title", title);
				row.put("description", description);
				data.add(row);
			}
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {

		}

		return data;
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public @ResponseBody HashMap<String, String> listInsert(Locale locale, Model model, @RequestParam String title,
			@RequestParam String description) {
		Connection connection = null;
		HashMap<String, String> result = new HashMap<String, String>();
		try {
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			connection = DriverManager.getConnection("jdbc:sqlite:/c:\\tomcat\\sunyoung.db", config.toProperties());

			String query = "INSERT INTO list (title,description) VALUES ('" + title + "','" + description + "')";
			System.out.println(query);
			Statement statement = connection.createStatement();
			int q = statement.executeUpdate(query);
			statement.close();
			connection.close();
		} catch (Exception e) {

		}
		result.put("result", "success");
		return result;
	}
	@RequestMapping(value = "/user_insert", method = RequestMethod.GET)
	public @ResponseBody HashMap<String, String> userInsert(Locale locale, Model model, @RequestParam String id,
			@RequestParam String password,@RequestParam String admin) {
		Connection connection = null;
		HashMap<String, String> result = new HashMap<String, String>();
		try {
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			connection = DriverManager.getConnection("jdbc:sqlite:/c:\\tomcat\\sunyoung.db", config.toProperties());

			String query = "INSERT INTO users (id,password,admin) VALUES ('" + id + "','" + password + "','" + admin + "')";
			System.out.println(query);
			Statement statement = connection.createStatement();
			int q = statement.executeUpdate(query);
			statement.close();
			connection.close();
		} catch (Exception e) {

		}
		result.put("result", "success");
		return result;
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public @ResponseBody HashMap<String, String> listMod(Locale locale, Model model, @RequestParam String idx,
			@RequestParam String title, @RequestParam String description) {
		Connection connection = null;
		HashMap<String, String> result = new HashMap<String, String>();
		try {
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			connection = DriverManager.getConnection("jdbc:sqlite:/c:\\tomcat\\sunyoung.db", config.toProperties());

			String query = "UPDATE list SET title='" + title + "',description='" + description + "' where idx=" + idx;
			Statement statement = connection.createStatement();
			int q = statement.executeUpdate(query);
			statement.close();
			connection.close();
		} catch (Exception e) {

		}
		result.put("result", "success");
		return result;
	}
	@RequestMapping(value = "input_password", method = RequestMethod.POST)
//  인자로 MulfiPartFile 객체, MultipartHttpServletRequest 객체, 업로드 하려는 도메인 클래스를 받는다
	public String inputPassword(@RequestParam("password") String password,@RequestParam("id") String id,
			HttpServletRequest request) {
		Connection connection = null;
		List idList = new ArrayList();
		List passList = new ArrayList();
		try {
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			connection = DriverManager.getConnection("jdbc:sqlite:/c:\\tomcat\\sunyoung.db", config.toProperties());

			String query = "SELECT * FROM users";// name LIKE '%" + name + "%'
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
		
			while (resultSet.next()) {
				int idx = resultSet.getInt("idx");
				String userId = resultSet.getString("id");
				String userPassword = resultSet.getString("password");
				idList.add(userId);
				passList.add(userPassword);
				
			}
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {

		}
			
		for(int i=0; i<idList.size(); i++) {
			if(id.equals(idList.get(i).toString()) && password.equals(passList.get(i).toString())) {
				HttpSession session =request.getSession() ;
				session.setAttribute("is_login", true);
				return "redirect:/list";
				
			}			
		}
		
			
		return "redirect:/";
		
	}

	
}
