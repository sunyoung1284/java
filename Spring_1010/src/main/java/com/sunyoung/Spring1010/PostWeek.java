package com.sunyoung.Spring1010;

import java.util.Calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PostWeek {
	public static void main(String[] args) throws ParseException {
		PostWeek test = new PostWeek();
		test.postWeek("2017");
		System.out.println(test.postWeek("2017"));
	}
	
	public String postWeek(String year) throws ParseException {

		Calendar calendar = Calendar.getInstance();
		calendar.setMinimalDaysInFirstWeek(4);
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		
		calendar.setTime(dateFormat.parse(year + "1231"));

		String maxWeek = ""+ calendar.getActualMaximum(Calendar.WEEK_OF_YEAR);
	    
	return maxWeek;

	}
	


}
