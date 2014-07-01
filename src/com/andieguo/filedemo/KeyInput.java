package com.andieguo.filedemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 将InputStream转化为InputStreamReader
 * BufferedReader具有一个readLine()方法，可以非常方便地一次读入一行内容。适合用于读取文本内容。
 * @author Administrator
 *
 */
public class KeyInput {

	public static void main(String[] args) {
//		input();
	}
	

	public static void input() {
		BufferedReader br = null;
		InputStreamReader reader = new InputStreamReader(System.in);
		br = new BufferedReader(reader);
		String buffer = null;
		try {
			while((buffer=br.readLine())!=null){
				if(buffer.equals("exit")){
					System.exit(1);
				}
				System.out.println("输入内容为："+buffer);
			}
			br.close();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
