package com.andieguo.filedemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = -1;
		byte[] a = new byte[1024];
		try {
			File f = new File("e:\\new.txt");
			InputStream in;
			in = new FileInputStream(f);
			while ((n = in.read(a, 0, 1024)) != -1) {
				String s = new String(a, 0, n);
				System.out.println(s);
			}
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("ÎÄ¼þ´íÎó£º" + e);
		}
	}

}
