package com.sunyoung.Spring0823;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
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

		return "index";
	}

	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public @ResponseBody HashMap<String, String> info(Locale locale, Model model) {
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("version", "1.0");

		return data;
	}

	@RequestMapping(value = "/user_list", method = RequestMethod.GET)
	public @ResponseBody ArrayList<HashMap> userList(Locale locale, Model model) {
		Connection connection = null;
		ArrayList<HashMap> data = new ArrayList<HashMap>();
		try {
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			connection = DriverManager.getConnection("jdbc:sqlite:/c:\\tomcat\\ajax.db", config.toProperties());

			String query = "SELECT * FROM users"; // name LIKE '%" + name + "%'
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int idx = resultSet.getInt("idx");
				String name = resultSet.getString("name");
				String address = resultSet.getString("address");
				String birthday = resultSet.getString("birthday");
				HashMap<String, String> row = new HashMap<String, String>();
				row.put("idx", "" + idx);
				row.put("name", name);
				row.put("address", address);
				row.put("birthday", birthday);
				data.add(row);
			}
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {

		}

		return data;
	}

	@RequestMapping(value = "/user_mod", method = RequestMethod.GET)
	public @ResponseBody HashMap<String, String> userMod(Locale locale, Model model, @RequestParam String idx,
			@RequestParam String name, @RequestParam String address) {
		Connection connection = null;
		HashMap<String, String> result = new HashMap<String, String>();
		try {
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			connection = DriverManager.getConnection("jdbc:sqlite:/c:\\tomcat\\ajax.db", config.toProperties());

			String query = "UPDATE users SET name='" + name + "',address='" + address + "' where idx=" + idx;
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
	public @ResponseBody HashMap<String, String> userInsert(Locale locale, Model model, @RequestParam String name,
			@RequestParam String address) {
		Connection connection = null;
		HashMap<String, String> result = new HashMap<String, String>();
		try {
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			connection = DriverManager.getConnection("jdbc:sqlite:/c:\\tomcat\\ajax.db", config.toProperties());

			String query = "INSERT INTO users (name,address) VALUES ('" + name + "','" + address + "')";
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

	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	public String posts(Locale locale, Model model) {

		return "posts";
	}

	@RequestMapping(value = "/posts_list", method = RequestMethod.GET)
	public @ResponseBody ArrayList<HashMap> postList(Locale locale, Model model) {
		Connection connection = null;
		ArrayList<HashMap> data = new ArrayList<HashMap>();
		try {
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			connection = DriverManager.getConnection("jdbc:sqlite:/c:\\tomcat\\ajax.db", config.toProperties());

			String query = "SELECT * FROM posts WHERE 1"; // name LIKE '%" + name + "%'
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

	@RequestMapping(value = "/details", method = RequestMethod.GET)
	public String details(Locale locale, Model model, @RequestParam String idx) {
		model.addAttribute("idx_string", idx);

		return "details";
	}

	@RequestMapping(value = "/posts_details", method = RequestMethod.GET)
	public @ResponseBody HashMap<String, String> postList(Locale locale, Model model, @RequestParam String idx) {
		Connection connection = null;
		HashMap<String, String> data = new HashMap<String, String>();
		try {
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			connection = DriverManager.getConnection("jdbc:sqlite:/c:\\tomcat\\ajax.db", config.toProperties());

			String query = "SELECT * FROM posts WHERE idx = " + idx; // name LIKE '%" + name + "%'
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				String title = resultSet.getString("title");
				String description = resultSet.getString("description");
				data.put("idx", idx);
				data.put("title", title);
				data.put("description", description);
			}
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {

		}

		return data;
	}

	@RequestMapping(value = "posts_mod", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public String postsMod(@RequestParam("uploadFile") MultipartFile uploadFile, MultipartHttpServletRequest request) {

		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String idx = request.getParameter("idx");
		String title = request.getParameter("title");
		String description = request.getParameter("description");

		UtilFile utilFile = new UtilFile();
		
		String uploadPath = "/Spring0823" + utilFile.fileUpload(request, uploadFile, new Object());
	
		if (uploadPath.equals("/Spring0823/resources/")) {
			
		} else {
			description = description + "<img src=\"" + uploadPath + "\" />";
		}

		Connection connection = null;

		HashMap<String, String> result = new HashMap<String, String>();
		try {
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			connection = DriverManager.getConnection("jdbc:sqlite:/c:\\tomcat\\ajax.db", config.toProperties());

			String query = "UPDATE posts SET title='" + title + "',description='" + description + "' where idx=" + idx;
			System.out.println(query);
			Statement statement = connection.createStatement();
			int q = statement.executeUpdate(query);
			statement.close();
			connection.close();
		} catch (Exception e) {

		}
		result.put("result", "success");

		return "redirect:/posts";

	}

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write(Locale locale, Model model) {
		return "insert";
	}

	@RequestMapping(value = "/posts_insert", method = RequestMethod.GET)
	public @ResponseBody HashMap<String, String> postsInsert(Locale locale, Model model, @RequestParam String title,
			@RequestParam String description) {
		Connection connection = null;
		HashMap<String, String> result = new HashMap<String, String>();
		try {
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			connection = DriverManager.getConnection("jdbc:sqlite:/c:\\tomcat\\ajax.db", config.toProperties());

			String query = "INSERT INTO posts (title,description) VALUES ('" + title + "','" + description + "')";
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

	@RequestMapping(value = "image_upload", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
//  인자로 MulfiPartFile 객체, MultipartHttpServletRequest 객체, 업로드 하려는 도메인 클래스를 받는다
	public String reAddProCtrl(@RequestParam("uploadFile") MultipartFile uploadFile,
			MultipartHttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String title = request.getParameter("title");
		String description = request.getParameter("description");

		UtilFile utilFile = new UtilFile();

		String uploadPath = "/Spring0823" + utilFile.fileUpload(request, uploadFile, new Object());

		description = description + "<img src=\"" + uploadPath + "\" />";

		Connection connection = null;
		HashMap<String, String> result = new HashMap<String, String>();
		try {
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			connection = DriverManager.getConnection("jdbc:sqlite:/c:\\tomcat\\ajax.db", config.toProperties());

			String query = "INSERT INTO posts (title, description) VALUES ('" + title + "', '" + description + "')";
			Statement statement = connection.createStatement();
			int q = statement.executeUpdate(query);
			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/posts";
	}

}