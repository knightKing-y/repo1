package com.chinasofti.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ToolUtil {

	/**
	 * 获得IP地址
	 * @param request
	 * @return
	 */

	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if (ip.indexOf("0:") != -1) {
			ip = "本地";
		}
		return ip;
	}

	public static String DatetoString(Date d){
		SimpleDateFormat sd= new SimpleDateFormat("yyyy-MM-dd");
		return sd.format(d);
	}
	
	public static Date StringToDate(String str) throws Throwable{
		SimpleDateFormat sd= new SimpleDateFormat("yyyy-MM-dd");
		return sd.parse(str);
	}
}
