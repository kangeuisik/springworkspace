package com.jafa.cal;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarEx {
	public static void main(String[] args) {
		Date date = new Date();
	
		//날짜 형식화
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		String formatDate = sdf.format(date);
		
		System.out.println(formatDate);
		
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.getTime());
		System.out.println(Calendar.DATE);
		System.out.println(calendar.get(Calendar.YEAR)+"년");
		System.out.println(calendar.get(Calendar.MONTH)+"월");
		System.out.println(calendar.get(Calendar.DATE)+"일");

		System.out.println(calendar.get(Calendar.DAY_OF_WEEK)+"요일");
		
		Calendar cal1 = Calendar.getInstance();
		cal1.set(2022, Calendar.AUGUST,21);
		cal1.add(Calendar.DATE, 5);
		cal1.add(Calendar.DATE, 2);
		System.out.println(cal1.getTime());
	}


}
