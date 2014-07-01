package com.andieguo.filedemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * һ��Ҫʹ���ֽ������������Կ����κ��ļ���������ʹ���ַ���������
 * @author Administrator
 *
 */
public class Copy {
	public static void main(String[] args) {
		copy2(args);
//		copy(args);
	}

	public static void copy(String[] args) {
		if(args.length!=2){
			System.out.println("����Ĳ�������ȷ");
			System.out.println("���ӣ�java Copy Դ�ļ�·�� Ŀ���ļ�·��");
			System.exit(1);//ϵͳ�˳�
		}
		File src = new File(args[0]);
		File dest = new File(args[1]);
		if(!src.exists()){
			System.out.println("Դ�ļ�������");
			System.exit(1);//ϵͳ�˳�
		}
		try {
			InputStream input = new FileInputStream(src);
			OutputStream output = new FileOutputStream(dest);
			if(input!=null&&output!=null){
				try {
					int temp =0;
					while((temp=input.read())!=-1){//һ�ζ�ȡһ���ֽ�
						output.write(temp);
					}
					input.close();
					output.close();
					System.out.println("�������");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void copy2(String[] args) {
		if(args.length!=2){
			System.out.println("����Ĳ�������ȷ");
			System.out.println("���ӣ�java Copy Դ�ļ�·�� Ŀ���ļ�·��");
			System.exit(1);//ϵͳ�˳�
		}
		File src = new File(args[0]);
		File dest = new File(args[1]);
		if(!src.exists()){
			System.out.println("Դ�ļ�������");
			System.exit(1);//ϵͳ�˳�
		}
		try {
			InputStream input = new FileInputStream(src);
			OutputStream output = new FileOutputStream(dest);
			if(input!=null&&output!=null){
				try {
					int temp =0;
					byte b[] = new byte[1024];
					while((temp=input.read(b))!=-1){//һ�ζ�ȡ1024���ֽ�,һ�߿���һ��д��
						output.write(b);
					}
					System.out.println("�������");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
