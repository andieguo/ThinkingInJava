package com.andieguo.filedemo;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
/**
 * �ֽ������ֽ�����Ϊ�ڵ㣻�ַ������ַ�����Ϊ�ڵ㣻
 * @author Administrator
 *
 */
public class StringReaderDemo {

	public static void main(String[] args) {
		read();
		write();
	}

	public static void write() {
		StringWriter sw = new StringWriter(20);
		sw.write("����һ�����ӣ��泯�󺣴�ů����\n");
		sw.write("����һ�����ӣ��泯�󺣴�ů����\n");
		sw.write("����һ�����ӣ��泯�󺣴�ů����\n");
		System.out.println(sw.toString());
	}

	public static void read() {
		String src = "����������һ���Ҹ�����";
		StringReader sr = new StringReader(src);
		char[] buffer = new char[20];
		int temp = 0;
		try {
			while((temp = sr.read(buffer))!=-1){
				System.out.println(new String(buffer,0,temp));
			}
			sr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
