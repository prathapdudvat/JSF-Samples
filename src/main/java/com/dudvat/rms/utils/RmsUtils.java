package com.dudvat.rms.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RmsUtils {
	public static SimpleDateFormat dbSdf=new SimpleDateFormat("yyyy-MM-dd");
	public static Date getToday(){
		Calendar cal=Calendar.getInstance();
		return cal.getTime();
	}
	
	public static String getTodayDbFormat(){
		return dbSdf.format(getToday());
	}
	
	public static String getDateDbFormat(Date dtVal){
		return dbSdf.format(dtVal);
	}
	
	 public static Date getStartDateOfCurrMonth() {
		    Calendar now = Calendar.getInstance();
		    now.set(now.get(Calendar.YEAR), now.get(Calendar.MONTH), 1);
		    return now.getTime();
		  }
	/*public static void main(String[] args) {
		System.out.println(getTodayDbFormat());
	}*/

}
