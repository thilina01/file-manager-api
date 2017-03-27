package com.trendsmixed.fma.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Format {


	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static Date toStartDate(String dateText) {

		Date startDate = new Date();
		try {
			startDate = sdf.parse(dateText+" 00:00:00");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return startDate;
	}
	
	public static Date toEndDate(String dateText) {

		Date endDate = new Date();
		try {
			endDate = sdf.parse(dateText+" 23:59:59");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return endDate;
	}
}
