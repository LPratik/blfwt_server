package com.pron.blfwt.admin.utils;

public class StringUtils {

	public static Boolean isNullOrEmpty(String str)
	{
		if(null!=str)
		{
			if(str.trim().length()>0)
				return false;
		}
		return true;
	}
}
