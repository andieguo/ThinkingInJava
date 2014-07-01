package com.andieguo.filedemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * 1、利用output写入内容；利用InputStream读取内容；
 * 2、默认将其覆盖追加
 * 3、换行
 * 4、FileOutputStream 和 FileInputStream的使用
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
		//1、打开一个文件
		File file = new File("e:\\lyfy\\a.txt");//如果文件本身不存在，则自动创建
		try {
			OutputStream out = new FileOutputStream(file,true);//默认将其覆盖，添加true属性表示追加
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
		//使用File.separator
		File file = new File("e:\\lyfy\\a.txt");//如果文件本身不存在，则自动创建
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
			byte b[]=new byte[(int) file.length()];//byte数组的实例化，1024的空间肯定比文件里的内容要大
			int size = in.read(b);
			System.out.println("读入数据的长度："+size);
			System.out.println("内容为："+new String(b));//把byte数组转化成数组
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void read2(){//知道输入流的对象是文件的大小
		File file = new File("e:\\lyfy\\a.txt");
		try {
			InputStream in = new FileInputStream(file);
			byte b[]=new byte[(int) file.length()];//byte数组的实例化，1024的空间肯定比文件里的内容要大
			for(int i=0;i<b.length;i++){
				b[i] = (byte) in.read();
			}
			System.out.println("内容为："+new String(b));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void read3(){//不知道文件大小
		File file = new File("e:\\lyfy\\a.txt");
		try {
			InputStream in = new FileInputStream(file);
			byte b[]=new byte[1024];//byte数组的实例化，1024的空间肯定比文件里的内容要大
			int temp = 0;//接收每一个读取进来的数据
			int len = 0;
			while((temp=in.read())!=-1){//表示还有文件没有读完
				b[len] = (byte) temp;
				len++;//每次读一个字节
			}
			System.out.println("内容为："+new String(b));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 很常用
	 */
	public static void copy(){//不知道文件大小
		File src = new File("e:\\lyfy\\Copy.java");//Copy.java是GBK编码
		File dest = new File("e:\\lyfy\\b.txt");//拷贝过去没有乱码
		try {
			InputStream in = new FileInputStream(src);
			OutputStream out = new FileOutputStream(dest);
			byte b[]=new byte[1024];//byte数组的实例化，1024的空间肯定比文件里的内容要大
			int temp = 0;//接收每一个读取进来的数据
			while((temp = in.read(b))!=-1){//表示还有文件没有读完
				out.write(b);
			}
			System.out.println("内容为："+new String(b,"GBK"));//编码方式
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void read5(){//不知道文件大小
		File file = new File("e:\\lyfy\\a.txt");
		try {
			InputStream in = new FileInputStream(file);
			byte b[]=new byte[1024];//byte数组的实例化，1024的空间肯定比文件里的内容要大
			int temp = 0;//接收每一个读取进来的数据
			while((temp=in.read(b, 1024, 1024))!=-1){//表示还有文件没有读完
			}
			System.out.println("内容为："+new String(b,"UTF-8"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
