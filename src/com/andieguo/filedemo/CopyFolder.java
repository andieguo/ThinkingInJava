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
 * 1���ļ���������ô��
 * 2�����ʹ������������--��copy.
 * 3�����������������ʹ��
 * 4��������Ҫ������copy�ı��ļ�
 * 5��BufferedReader����һ��readLine()���������Էǳ������һ�ζ���һ�����ݡ��ʺ����ڶ�ȡ�ı����ݡ�
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
				//System.out.println(dir+"xxxxxxxx"+name);//����
				File file = new File(dir,name);
				if(file.isFile()&&name.endsWith(".txt")){
					return true;
				}else{
					return false;
				}
			}
		});
		
		for (String str : strArray) {
//			System.out.println(str);//����
			File srcfile = new File(src,str);
			File destfile = new File(dest,str);
			try {
				//�ַ��������������
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
