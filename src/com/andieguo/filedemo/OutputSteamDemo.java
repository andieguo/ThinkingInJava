package com.andieguo.filedemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * 1������outputд�����ݣ�����InputStream��ȡ���ݣ�
 * 2��Ĭ�Ͻ��串��׷��
 * 3������
 * 4��FileOutputStream �� FileInputStream��ʹ��
 * @author Administrator
 *
 */
public class OutputSteamDemo {

	public static void main(String[] args) {
		//write("hello,good boy");
		//append("welcome to beijinng");
//		read5();
		copy();
	}

	public static void append(String string) {
		//1����һ���ļ�
		File file = new File("e:\\lyfy\\a.txt");//����ļ��������ڣ����Զ�����
		try {
			OutputStream out = new FileOutputStream(file,true);//Ĭ�Ͻ��串�ǣ����true���Ա�ʾ׷��
			byte b[] = string.getBytes();
			for(int i=0;i<b.length;i++){
				out.write(b[i]);//write(int b)
			}
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void write(String string) {
		//ʹ��File.separator
		File file = new File("e:\\lyfy\\a.txt");//����ļ��������ڣ����Զ�����
		try {
			OutputStream out = new FileOutputStream(file,true);
			byte b[] = string.getBytes();
			out.write(b);//write(byte[] b)
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void read(){
		File file = new File("e:\\lyfy\\a.txt");
		try {
			InputStream in = new FileInputStream(file);
			byte b[]=new byte[(int) file.length()];//byte�����ʵ������1024�Ŀռ�϶����ļ��������Ҫ��
			int size = in.read(b);
			System.out.println("�������ݵĳ��ȣ�"+size);
			System.out.println("����Ϊ��"+new String(b));//��byte����ת��������
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void read2(){//֪���������Ķ������ļ��Ĵ�С
		File file = new File("e:\\lyfy\\a.txt");
		try {
			InputStream in = new FileInputStream(file);
			byte b[]=new byte[(int) file.length()];//byte�����ʵ������1024�Ŀռ�϶����ļ��������Ҫ��
			for(int i=0;i<b.length;i++){
				b[i] = (byte) in.read();
			}
			System.out.println("����Ϊ��"+new String(b));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void read3(){//��֪���ļ���С
		File file = new File("e:\\lyfy\\a.txt");
		try {
			InputStream in = new FileInputStream(file);
			byte b[]=new byte[1024];//byte�����ʵ������1024�Ŀռ�϶����ļ��������Ҫ��
			int temp = 0;//����ÿһ����ȡ����������
			int len = 0;
			while((temp=in.read())!=-1){//��ʾ�����ļ�û�ж���
				b[len] = (byte) temp;
				len++;//ÿ�ζ�һ���ֽ�
			}
			System.out.println("����Ϊ��"+new String(b));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * �ܳ���
	 */
	public static void copy(){//��֪���ļ���С
		File src = new File("e:\\lyfy\\Copy.java");//Copy.java��GBK����
		File dest = new File("e:\\lyfy\\b.txt");//������ȥû������
		try {
			InputStream in = new FileInputStream(src);
			OutputStream out = new FileOutputStream(dest);
			byte b[]=new byte[1024];//byte�����ʵ������1024�Ŀռ�϶����ļ��������Ҫ��
			int temp = 0;//����ÿһ����ȡ����������
			while((temp = in.read(b))!=-1){//��ʾ�����ļ�û�ж���
				out.write(b);
			}
			System.out.println("����Ϊ��"+new String(b,"GBK"));//���뷽ʽ
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void read5(){//��֪���ļ���С
		File file = new File("e:\\lyfy\\a.txt");
		try {
			InputStream in = new FileInputStream(file);
			byte b[]=new byte[1024];//byte�����ʵ������1024�Ŀռ�϶����ļ��������Ҫ��
			int temp = 0;//����ÿһ����ȡ����������
			while((temp=in.read(b, 1024, 1024))!=-1){//��ʾ�����ļ�û�ж���
			}
			System.out.println("����Ϊ��"+new String(b,"UTF-8"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
