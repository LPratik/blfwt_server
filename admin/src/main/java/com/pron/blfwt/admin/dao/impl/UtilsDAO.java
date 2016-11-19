package com.pron.blfwt.admin.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

public class UtilsDAO{

	public static String getCurrentWeek(Session session) {
		SQLQuery query = session.createSQLQuery("SELECT CEILING(DAY(CURRENT_TIMESTAMP)/7) ");
		Number weekValue = (Number) query.uniqueResult();
		return "Wk " + weekValue;

	}

	public static String getCurrentDay(Session session) {
		SQLQuery query = session.createSQLQuery("SELECT DATE_FORMAT(CURRENT_TIMESTAMP, '%a')");
		String dayOfWeek = (String) query.uniqueResult();

		return dayOfWeek;

	}
	
	public static Date getDBTimeStamp(Session session){
		List list = session.createSQLQuery("select CURRENT_TIMESTAMP from dual").list();
        java.util.Date date = (java.util.Date) list.get(0);
        return date;
	}
	
}