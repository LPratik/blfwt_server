package com.pron.blfwt.admin.utils;

import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;

public class Util {

	public static String getString(Map<String, String> params, String key) {
		String toret = null;
		try {
			toret = params.get(key).toString();
		} catch (Exception ex) {
		}
		return toret;
	}
	
	public static boolean checkparam(String param) {
		if (param != null && param.trim().length() > 0) {
			return true;
		} else {
			return false;
		}
	}
	public static String convertToEpoch(String date)
	{
		String fromTimeZone = "UTC";
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		dateFormat.setTimeZone(TimeZone.getTimeZone(fromTimeZone));
		Date parsedDate = null;
		try {
			 parsedDate = dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		cal.setTime(parsedDate);
		Long epoch = cal.getTimeInMillis();
		return epoch.toString();
	}
	
	public static Date epochToDate(String epochString)
	{
		Long epoch = Long.parseLong(epochString);
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		cal.setTimeInMillis(epoch);
		return cal.getTime();
	}
	
	public static String epochToDateString(String epochString)
	{
		Long epoch = Long.parseLong(epochString);
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		cal.setTimeInMillis(epoch);
		return cal.getTime().toString();
	}
	
	public static Date convertDate(String date)
	{
		String fromTimeZone = "UTC";
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		dateFormat.setTimeZone(TimeZone.getTimeZone(fromTimeZone));
		Date parsedDate = null;
		try {
			 parsedDate = dateFormat.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return parsedDate;
	}

	public static void checkPutValueInMap(Map<String, Object> params, String paramName, String paramValue){
		if(!StringUtils.isNullOrEmpty(paramValue))
			params.put(paramName, paramValue);
	}
	
	public static String getExceptionStackTrace(Exception e) {
		StringBuilder sb = new StringBuilder();
		for (StackTraceElement element : e.getStackTrace()) {
			sb.append(element.toString());
			sb.append("\n \t");
		}
		return sb.toString();
	}
	
	public static String hash(String string) throws Exception
    {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(string.getBytes());
        
        byte byteData[] = md.digest();
 
        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
 
        return sb.toString();
    }
	
	public static String convertDateToEpoch(Date date){
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		cal.setTime(date);
		Long epoch = cal.getTimeInMillis();
		return epoch.toString();
	}
	
	public static boolean  isThisDateValid(String dateToValidate){
		String dateStr = Util.epochToDateString(dateToValidate);
		if(dateStr == null){
			return false;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
		try {
			//if not valid, it will throw ParseException
			Date date = sdf.parse(dateStr);
			System.out.println(date);
		
		} catch (ParseException e) {
			
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
