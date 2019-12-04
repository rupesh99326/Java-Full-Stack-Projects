package com.cognizant.truyum.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	
	public static Date convertToDate(String date)
	
	{
		SimpleDateFormat f1=new SimpleDateFormat("dd/MM/yyyy");
			Date d;
			try {
				d = f1.parse(date);return d;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	return null;
		
		
	}
	
	
}
