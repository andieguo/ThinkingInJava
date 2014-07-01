package com.andieguo.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.util.Date;
import java.util.Random;

public class DateTimeDemo {
	public static void main(String[] args) {
		// showCalendar();// 2013_8_27_19_52_48
		// showDate();
//		showTime();
//		System.out.println(new Date(2011,9,3).after(new Date(2012,9,2)));
		test2();
	}

	/**
	 * 在星期五，2012年3月2日，下午大约是22:38:41的样子，上面的例子在系统输出设备上显示的结果是 1330699121772。
	 * 值得注意的是我们使用了Date
	 * 构造函数创建一个日期对象，这个构造函数没有接受任何参数，而这个构造函数在内部使用了System.currentTimeMillis()
	 * 方法来从系统获取日期。 现在我们已经知道了如何获取从1970年1月1日开始经历的毫秒数了。我们如何才能以一种用户明白的格式来显示这个日期呢?
	 * 在这里类java.text.SimpleDateFormat 和它的抽象基类 java.text.DateFormat 就派得上用场了。
	 */
	private static void showTime() {
		// TODO Auto-generated method stub
		Date date = new Date();
		System.out.println(date.getTime()); // 1380284569280
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE-MMMM-dd-yyyy");  
	    System.out.println(dateFormat.format(date));                // Friday-March-02-2012 
	    dateFormat = new SimpleDateFormat("EE-MM-dd-yy");
	    System.out.println(dateFormat.format(date)); 
	}

	public static void test(){
		//2014-01-06T14:43:33.4333 +0800
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ss.ms Z");
		System.out.println(sdf.format(d));
		
	}
	
	public static void test3(){
		Date d2 = new Date(108, 9, 1);
		int year = d2.getYear() + 1900;// 年份
		int month = d2.getMonth() + 1; // 月份
		int date = d2.getDate();// 日期
		int hour = d2.getHours();// 小时
		int minute = d2.getMinutes();// 分钟
		int second = d2.getSeconds();// 秒
		int day = d2.getDay();// 星期几
		System.out.println("年份：" + year);
		System.out.println("月份：" + month);
		System.out.println("日期：" + date);
		System.out.println("小时：" + hour);
		System.out.println("分钟：" + minute);
		System.out.println("秒：" + second);
		System.out.println("星期：" + day);
	}
	public static void test2(){
		//2014-01-06T14:43:33.4333 +0800
		SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ss.ms");
		try {
			Date d2 = sdf.parse("2013-12-24T17:56:12.214996+08:00");
			int year = d2.getYear() + 1900;// 年份
			int month = d2.getMonth() + 1; // 月份
			int date = d2.getDate();// 日期
			int hour = d2.getHours();// 小时
			int minute = d2.getMinutes();// 分钟
			int second = d2.getSeconds();// 秒
			int day = d2.getDay();// 星期几
			System.out.println("年份：" + year);
			System.out.println("月份：" + month);
			System.out.println("日期：" + date);
			System.out.println("小时：" + hour);
			System.out.println("分钟：" + minute);
			System.out.println("秒：" + second);
			System.out.println("星期：" + day);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 public static Date stringToDate(String str) {
	        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	        Date date = null;
	        try {
	            // Fri Feb 24 00:00:00 CST 2012
	            date = format.parse(str); 
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        // 2012-02-24
	        date = java.sql.Date.valueOf(str);
	                                             
	        return date;
	    }
	public static void showDate() {
		Date d2 = new Date();
		System.out.println(d2);// Fri Sep 27 19:52:48 CST 2013

		int year = d2.getYear() + 1900;// 年份
		int month = d2.getMonth() + 1; // 月份
		int date = d2.getDate();// 日期
		int hour = d2.getHours();// 小时
		int minute = d2.getMinutes();// 分钟
		int second = d2.getSeconds();// 秒
		int day = d2.getDay();// 星期几
		System.out.println("年份：" + year);
		System.out.println("月份：" + month);
		System.out.println("日期：" + date);
		System.out.println("小时：" + hour);
		System.out.println("分钟：" + minute);
		System.out.println("秒：" + second);
		System.out.println("星期：" + day);
	}

	public static void showCalendar() {
		// Calendar.YEAR——年份
		// Calendar.MONTH——月份
		// Calendar.DATE——日期
		// Calendar.DAY_OF_MONTH——日期，和上面的字段完全相同
		// Calendar.HOUR——12小时制的小时数
		// Calendar.HOUR_OF_DAY——24小时制的小时数
		// Calendar.MINUTE——分钟
		// Calendar.SECOND——秒
		// Calendar.DAY_OF_WEEK——星期几
		Calendar c = Calendar.getInstance();// 不能使用new来获取实例；
		int mYear = c.get(Calendar.YEAR);
		int mMonth = c.get(Calendar.MONTH) + 1;
		int mDay = c.get(Calendar.DAY_OF_MONTH);
		int mHour = c.get(Calendar.HOUR_OF_DAY);
		int mMinute = c.get(Calendar.MINUTE);
		int mSencond = c.get(Calendar.SECOND);
		System.out.println(mYear + "_" + mMonth + "_" + mDay + "_" + mHour
				+ "_" + mMinute + "_" + mSencond);
	}
}
