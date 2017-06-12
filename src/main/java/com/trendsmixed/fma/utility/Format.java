package com.trendsmixed.fma.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Format {


	static SimpleDateFormat yyyy_MM_dd_HH_mm_ss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static final SimpleDateFormat yyyy_MM = new SimpleDateFormat("yyyy-MM");

	public static Date toStartDate(String dateText) {

		Date startDate = new Date();
		try {
			startDate = yyyy_MM_dd_HH_mm_ss.parse(dateText+" 00:00:00");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return startDate;
	}
	
	public static Date toEndDate(String dateText) {

		Date endDate = new Date();
		try {
			endDate = yyyy_MM_dd_HH_mm_ss.parse(dateText+" 23:59:59");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return endDate;
	}
}
