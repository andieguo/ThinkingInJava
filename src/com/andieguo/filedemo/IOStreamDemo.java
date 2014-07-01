package com.andieguo.filedemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * InputStreamReader是InputStream和Reader之间的桥梁，
 * 由于System.in是字节流，需要用它来包装之后变为字符流供给BufferedReader使用。
 * 
 * @author Administrator
 * 
 */
public class IOStreamDemo {
	static List<String> filelist = new ArrayList<String>();//不能放在递归方法内部
	/**
	 * 1、字符串转换为文件 2、文本文件转换为字符串
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		// fun();
		// fun2();
		// fun3();
		// fun4();
		long a = System.currentTimeMillis();
		List<String> filelist = findMp3File("e:\\Kugou歌曲");
//		for(String filename:filelist){
//			System.out.println(filename);
//		}
		System.out.println(System.currentTimeMillis() - a);
	}
	
	/**
	 * 递归遍历文件夹下的所有文件
	 * @param strPath
	 */
	public static List<String> findMp3File(String strPath) {
		File dir = new File(strPath);
		File[] files = dir.listFiles();
		
		if (files == null)
			return null;
		for (int i = 0; i < files.length; i++) {
			if (files[i].isDirectory()) {//如果文件是目录
				findMp3File(files[i].getAbsolutePath());
			} else {//如果是文件
				String strFileName = files[i].getAbsolutePath().toLowerCase();
				if(strFileName.endsWith(".mp3")){
//					System.out.println("---" + strFileName);
					filelist.add(files[i].getAbsolutePath());
				}
			}
		}
		return filelist;
	}
	
	/**
	 * 递归遍历文件夹下的所有文件
	 * @param strPath
	 */
	public static void refreshFileList(String strPath) {
		File dir = new File(strPath);
		File[] files = dir.listFiles();
		ArrayList<String> filelist = new ArrayList<String>();
		if (files == null)
			return;
		for (int i = 0; i < files.length; i++) {
			if (files[i].isDirectory()) {//如果文件是目录
				refreshFileList(files[i].getAbsolutePath());
			} else {//如果是文件
				String strFileName = files[i].getAbsolutePath().toLowerCase();
				System.out.println("---" + strFileName);
				filelist.add(files[i].getAbsolutePath());
			}
		}
	}

	/**
	 * 6. 将字符串数据写入文件（更加简单）：实现了字符串转换为文件
	 */
	public static void fun6() {

		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(
					"e:\\bak.txt"));
			out.write("从明天起做一个幸福的人");
			out.close();// FileWriter需要关闭么？
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 5. 将字符串数据写入文件（是否有必要）
	 */
	public static void fun5() {

		try {
			BufferedReader in = new BufferedReader(new StringReader(
					"从明天起做一个幸福的人"));
			BufferedWriter out = new BufferedWriter(new FileWriter(
					"e:\\bak.txt"));
			String line = null;
			while ((line = in.readLine()) != null) {
				out.write(line);
				out.newLine();// 很关键
				out.flush();
			}
			in.close();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 4、将系统输入的内容（InputStream）写入到文件 -
	 * 追加文件：使用FileOutputStream，在构造FileOutputStream时，把第二个参数设为true -
	 * 追加文件：使用FileWriter，打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
	 */
	public static void fun4() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			BufferedWriter bw = new BufferedWriter(new FileWriter(
					"e:\\bak.txt", true));// 追加写入
			String buffer = null;
			while ((buffer = br.readLine()) != null) {
				if (buffer.equals("exit")) {
					System.exit(1);
				}
				bw.write(buffer);
				bw.newLine();
				bw.flush();
			}
			bw.close();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 3. 这是从文件中逐行读入数据，并写入另外的文件(完全复制)
	 */
	public static void fun3() {
		try {
			BufferedReader in = new BufferedReader(new FileReader(
					"e:\\finalDemo.txt"));
			BufferedWriter out = new BufferedWriter(new FileWriter(
					"e:\\bak.txt"));
			String line = null;
			while ((line = in.readLine()) != null) {
				out.write(line);
				out.newLine();// 很关键
				out.flush();
			}
			in.close();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 2. 这是从文件中逐行读入数据：文本文件转换为字符串
	 */
	public static String fun2() {
		String line = null;
		String result = "";
		try {
			BufferedReader in = new BufferedReader(new FileReader(
					"e:\\finalDemo.txt"));
			while ((line = in.readLine()) != null) {
				result = result + line + "\r\n";
			}
			System.out.print(result);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 1. 这是从键盘读入一行数据,返回的是一个字符串
	 */
	public static void fun() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter a line:");
		String buffer = null;
		try {
			while ((buffer = br.readLine()) != null) {
				if (buffer.equals("exit")) {
					System.exit(1);
				}
				System.out.println("输入的内容：" + buffer);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
