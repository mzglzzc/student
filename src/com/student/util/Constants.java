package com.student.util;

public class Constants {
	public static final String MYSQL_KEY = "student";
	public static final int SESSION_OVER_TIME = Integer.parseInt(PropertyUtil.getProperty("session_over_time","300"));
}
