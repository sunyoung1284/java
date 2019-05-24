package com.sunyoung.spring2;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET) //주소
	public String home(Locale locale, Model model) {
		DataReader dataReader = new DataReader("c:\\tomcat\\tomcat.sqlite", "students");
		dataReader.open();
		try {
			model.addAttribute("query_result", dataReader.selectData());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
		} finally {
			dataReader.close(); //열었음 닫아줘야지
		}

		return "NewFile"; //파일
	}
	@RequestMapping(value = "/input_data", method = RequestMethod.GET) //주소
	public String inputData(Locale locale, Model model) {
		
		return "done"; //파일
	}

}
