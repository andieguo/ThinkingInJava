package com.andieguo.filedemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * 一定要使用字节输入流（可以拷贝任何文件），不能使用字符输入流，
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
			System.out.println("输入的参数不正确");
			System.out.println("例子：java Copy 源文件路径 目标文件路径");
			System.exit(1);//系统退出
		}
		File src = new File(args[0]);
		File dest = new File(args[1]);
		if(!src.exists()){
			System.out.println("源文件不存在");
			System.exit(1);//系统退出
		}
		try {
			InputStream input = new FileInputStream(src);
			OutputStream output = new FileOutputStream(dest);
			if(input!=null&&output!=null){
				try {
					int temp =0;
					while((temp=input.read())!=-1){//一次读取一个字节
						output.write(temp);
					}
					input.close();
					output.close();
					System.out.println("拷贝完成");
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
			System.out.println("输入的参数不正确");
			System.out.println("例子：java Copy 源文件路径 目标文件路径");
			System.exit(1);//系统退出
		}
		File src = new File(args[0]);
		File dest = new File(args[1]);
		if(!src.exists()){
			System.out.println("源文件不存在");
			System.exit(1);//系统退出
		}
		try {
			InputStream input = new FileInputStream(src);
			OutputStream output = new FileOutputStream(dest);
			if(input!=null&&output!=null){
				try {
					int temp =0;
					byte b[] = new byte[1024];
					while((temp=input.read(b))!=-1){//一次读取1024个字节,一边拷贝一边写入
						output.write(b);
					}
					System.out.println("拷贝完成");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
