package com.andieguo.filedemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
/**
 * 1、文件不存在怎么办
 * 2、如何使用先重新命名--再copy.
 * 3、输入流与输出流的使用
 * 4、该类主要适用于copy文本文件
 * 5、BufferedReader具有一个readLine()方法，可以非常方便地一次读入一行内容。适合用于读取文本内容。
 * @author Administrator
 *
 */
public class CopyFolder {
	public static void main(String[] args) {
		File src = new File("e:\\lyfy");
		File dest = new File("f:\\");
		String[] strArray = src.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				//System.out.println(dir+"xxxxxxxx"+name);//测试
				File file = new File(dir,name);
				if(file.isFile()&&name.endsWith(".txt")){
					return true;
				}else{
					return false;
				}
			}
		});
		
		for (String str : strArray) {
//			System.out.println(str);//测试
			File srcfile = new File(src,str);
			File destfile = new File(dest,str);
			try {
				//字符缓冲输入输出流
				BufferedReader br = new BufferedReader(new FileReader(srcfile));
				BufferedWriter bw = new BufferedWriter(new FileWriter(destfile));
				String line = null;
				while((line=br.readLine())!=null){
					bw.write(line);
					bw.newLine();
					bw.flush();
				}
				bw.close();
				br.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String[] strArray2 = dest.list();
		for(String str:strArray2){
			String newName = str.replace(".txt", ".c");
			File oldFile = new File(dest,str);
			File newFile = new File(dest,newName);
			oldFile.renameTo(newFile);
		}
	}

}
