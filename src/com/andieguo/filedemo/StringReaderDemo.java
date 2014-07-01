package com.andieguo.filedemo;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
/**
 * 字节流以字节数组为节点；字符流以字符数组为节点；
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
		sw.write("我有一所房子，面朝大海春暖花开\n");
		sw.write("我有一所房子，面朝大海春暖花开\n");
		sw.write("我有一所房子，面朝大海春暖花开\n");
		System.out.println(sw.toString());
	}

	public static void read() {
		String src = "从明天起，做一个幸福的人";
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
