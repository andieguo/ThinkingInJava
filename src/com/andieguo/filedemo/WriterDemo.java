package com.andieguo.filedemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
/**
 * FileReader和FileWriter的使用
 * @author Administrator
 *
 */
public class WriterDemo {
	public static void main(String[] args) {
		write();
		read();
	}

	public static void read() {
		File file = new File("e:\\lyfy\\a.txt");
		try {
			Reader in = new FileReader(file);
			char cbuf[] = new char[2];
			int temp = 0;
			while((temp=in.read(cbuf))!=-1){
				System.out.print(String.valueOf(cbuf));//把char[]转化为String
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void write() {
		File file = new File("e:\\lyfy\\a.txt");
		try {
			Writer out = new FileWriter(file,true);//追加
			out.write("\r\tdajiahao0000000");//换行
			//所有的内容都被写入到内存缓存区中，关闭out的时候会强制将缓存区的内容写入文件。
			out.flush();//强制性清空缓存区中的内容
			out.close();//不关闭out是无法写数据到文件中的
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
