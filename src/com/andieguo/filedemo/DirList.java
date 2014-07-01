package com.andieguo.filedemo;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;
/**
 * FilenameFilter的使用
 * @author Administrator
 *
 */
public class DirList {

	public static void main(String[] args) {
		dirList("e:\\lyfy",".*.exe");
	}

	public static void dirList(String path) {
		File src = new File(path);
		String[] list = src.list();
		for (String dirItem : list) {
			System.out.println(dirItem);
		}
	}

	public static void dirList(String path,final String regex) {
		File src = new File(path);
		String[] list = src.list(new FilenameFilter() {
			private Pattern pattern = Pattern.compile(regex);
			@Override
			public boolean accept(File dir, String name) {
				return pattern.matcher(name).matches();
			}
		});
		Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);//按字母排序
		for (String dirItem : list) {
			System.out.println(dirItem);
		}
	}
	
	public static void dirList2(String path) {
		File src = new File(path);
		String[] list = src.list(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
//				System.out.println("dir:"+dir+",name:"+name);
				File file = new File(dir,name);
				if(file.isFile()&&name.endsWith(".exe")){
					file.delete();
					return true;
				}
				return false;
			}
		});
		for (String dirItem : list) {
			System.out.println(dirItem);
		}
	}
}
