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
	 * �������壬2012��3��2�գ������Լ��22:38:41�����ӣ������������ϵͳ����豸����ʾ�Ľ���� 1330699121772��
	 * ֵ��ע���������ʹ����Date
	 * ���캯������һ�����ڶ���������캯��û�н����κβ�������������캯�����ڲ�ʹ����System.currentTimeMillis()
	 * ��������ϵͳ��ȡ���ڡ� ���������Ѿ�֪������λ�ȡ��1970��1��1�տ�ʼ�����ĺ������ˡ�������β�����һ���û����׵ĸ�ʽ����ʾ���������?
	 * ��������java.text.SimpleDateFormat �����ĳ������ java.text.DateFormat ���ɵ����ó��ˡ�
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
		int year = d2.getYear() + 1900;// ���
		int month = d2.getMonth() + 1; // �·�
		int date = d2.getDate();// ����
		int hour = d2.getHours();// Сʱ
		int minute = d2.getMinutes();// ����
		int second = d2.getSeconds();// ��
		int day = d2.getDay();// ���ڼ�
		System.out.println("��ݣ�" + year);
		System.out.println("�·ݣ�" + month);
		System.out.println("���ڣ�" + date);
		System.out.println("Сʱ��" + hour);
		System.out.println("���ӣ�" + minute);
		System.out.println("�룺" + second);
		System.out.println("���ڣ�" + day);
	}
	public static void test2(){
		//2014-01-06T14:43:33.4333 +0800
		SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ss.ms");
		try {
			Date d2 = sdf.parse("2013-12-24T17:56:12.214996+08:00");
			int year = d2.getYear() + 1900;// ���
			int month = d2.getMonth() + 1; // �·�
			int date = d2.getDate();// ����
			int hour = d2.getHours();// Сʱ
			int minute = d2.getMinutes();// ����
			int second = d2.getSeconds();// ��
			int day = d2.getDay();// ���ڼ�
			System.out.println("��ݣ�" + year);
			System.out.println("�·ݣ�" + month);
			System.out.println("���ڣ�" + date);
			System.out.println("Сʱ��" + hour);
			System.out.println("���ӣ�" + minute);
			System.out.println("�룺" + second);
			System.out.println("���ڣ�" + day);
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

		int year = d2.getYear() + 1900;// ���
		int month = d2.getMonth() + 1; // �·�
		int date = d2.getDate();// ����
		int hour = d2.getHours();// Сʱ
		int minute = d2.getMinutes();// ����
		int second = d2.getSeconds();// ��
		int day = d2.getDay();// ���ڼ�
		System.out.println("��ݣ�" + year);
		System.out.println("�·ݣ�" + month);
		System.out.println("���ڣ�" + date);
		System.out.println("Сʱ��" + hour);
		System.out.println("���ӣ�" + minute);
		System.out.println("�룺" + second);
		System.out.println("���ڣ�" + day);
	}

	public static void showCalendar() {
		// Calendar.YEAR�������
		// Calendar.MONTH�����·�
		// Calendar.DATE��������
		// Calendar.DAY_OF_MONTH�������ڣ���������ֶ���ȫ��ͬ
		// Calendar.HOUR����12Сʱ�Ƶ�Сʱ��
		// Calendar.HOUR_OF_DAY����24Сʱ�Ƶ�Сʱ��
		// Calendar.MINUTE��������
		// Calendar.SECOND������
		// Calendar.DAY_OF_WEEK�������ڼ�
		Calendar c = Calendar.getInstance();// ����ʹ��new����ȡʵ����
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
