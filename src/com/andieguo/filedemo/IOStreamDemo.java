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
 * InputStreamReader��InputStream��Reader֮���������
 * ����System.in���ֽ�������Ҫ��������װ֮���Ϊ�ַ�������BufferedReaderʹ�á�
 * 
 * @author Administrator
 * 
 */
public class IOStreamDemo {
	static List<String> filelist = new ArrayList<String>();//���ܷ��ڵݹ鷽���ڲ�
	/**
	 * 1���ַ���ת��Ϊ�ļ� 2���ı��ļ�ת��Ϊ�ַ���
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		// fun();
		// fun2();
		// fun3();
		// fun4();
		long a = System.currentTimeMillis();
		List<String> filelist = findMp3File("e:\\Kugou����");
//		for(String filename:filelist){
//			System.out.println(filename);
//		}
		System.out.println(System.currentTimeMillis() - a);
	}
	
	/**
	 * �ݹ�����ļ����µ������ļ�
	 * @param strPath
	 */
	public static List<String> findMp3File(String strPath) {
		File dir = new File(strPath);
		File[] files = dir.listFiles();
		
		if (files == null)
			return null;
		for (int i = 0; i < files.length; i++) {
			if (files[i].isDirectory()) {//����ļ���Ŀ¼
				findMp3File(files[i].getAbsolutePath());
			} else {//������ļ�
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
	 * �ݹ�����ļ����µ������ļ�
	 * @param strPath
	 */
	public static void refreshFileList(String strPath) {
		File dir = new File(strPath);
		File[] files = dir.listFiles();
		ArrayList<String> filelist = new ArrayList<String>();
		if (files == null)
			return;
		for (int i = 0; i < files.length; i++) {
			if (files[i].isDirectory()) {//����ļ���Ŀ¼
				refreshFileList(files[i].getAbsolutePath());
			} else {//������ļ�
				String strFileName = files[i].getAbsolutePath().toLowerCase();
				System.out.println("---" + strFileName);
				filelist.add(files[i].getAbsolutePath());
			}
		}
	}

	/**
	 * 6. ���ַ�������д���ļ������Ӽ򵥣���ʵ�����ַ���ת��Ϊ�ļ�
	 */
	public static void fun6() {

		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(
					"e:\\bak.txt"));
			out.write("����������һ���Ҹ�����");
			out.close();// FileWriter��Ҫ�ر�ô��
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 5. ���ַ�������д���ļ����Ƿ��б�Ҫ��
	 */
	public static void fun5() {

		try {
			BufferedReader in = new BufferedReader(new StringReader(
					"����������һ���Ҹ�����"));
			BufferedWriter out = new BufferedWriter(new FileWriter(
					"e:\\bak.txt"));
			String line = null;
			while ((line = in.readLine()) != null) {
				out.write(line);
				out.newLine();// �ܹؼ�
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
	 * 4����ϵͳ��������ݣ�InputStream��д�뵽�ļ� -
	 * ׷���ļ���ʹ��FileOutputStream���ڹ���FileOutputStreamʱ���ѵڶ���������Ϊtrue -
	 * ׷���ļ���ʹ��FileWriter����һ��д�ļ��������캯���еĵڶ�������true��ʾ��׷����ʽд�ļ�
	 */
	public static void fun4() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			BufferedWriter bw = new BufferedWriter(new FileWriter(
					"e:\\bak.txt", true));// ׷��д��
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
	 * 3. ���Ǵ��ļ������ж������ݣ���д��������ļ�(��ȫ����)
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
				out.newLine();// �ܹؼ�
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
	 * 2. ���Ǵ��ļ������ж������ݣ��ı��ļ�ת��Ϊ�ַ���
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
	 * 1. ���ǴӼ��̶���һ������,���ص���һ���ַ���
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
				System.out.println("��������ݣ�" + buffer);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
