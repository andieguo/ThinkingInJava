package com.andieguo.filedemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * ��InputStreamת��ΪInputStreamReader
 * BufferedReader����һ��readLine()���������Էǳ������һ�ζ���һ�����ݡ��ʺ����ڶ�ȡ�ı����ݡ�
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
				System.out.println("��������Ϊ��"+buffer);
			}
			br.close();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
