package com.andieguo.filedemo;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
/**
 * 1、Iterable的继承实现
 * 2、递归
 * 4、正则表达式
 * 3、FilenameFilter的使用
 * @author Administrator
 *
 */
public class Directory {
	/**
	 * 调用dir.listFiles()返回File[]可到的文件的各种属性，调用dir.list()返回String[]只能得到文件名。
	 * 
	 * @param dir
	 * @param regex
	 * @return
	 */
	public static File[] local(File dir, final String regex) {

		return dir.listFiles(new FilenameFilter() {
			private Pattern pattern = Pattern.compile(regex);

			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				return pattern.matcher(name).matches();
			}
		});
	}

	public static File[] local(String path, final String regex) {
		return local(new File(path), regex);
	}

	public static class TreeInfo implements Iterable<File> {
		public List<File> files = new ArrayList<File>();
		public List<File> dirs = new ArrayList<File>();

		@Override
		public Iterator<File> iterator() {
			return files.iterator();//很关键，默认迭代的是文件列表；也可选择迭代目录列表
		}
		void addAll(TreeInfo other){
			files.addAll(other.files);
			dirs.addAll(other.dirs);
		}
		@Override
		public String toString() {
			return "TreeInfo [files=" + files + ", dirs=" + dirs + "]";
		}
	}
	
	public static TreeInfo walk(String start,String regex){
		return recurseDirs(new File(start), regex);
	}
	
	public static TreeInfo walk(File start,String regex){
		return recurseDirs(start, regex);
	}

	public static TreeInfo walk(String start){
		return recurseDirs(new File(start), ".*");
	}
	public static TreeInfo walk(File start){
		return recurseDirs(start,  ".*");
	}
	
	public static TreeInfo recurseDirs(File startDir,String regex){
		TreeInfo treeInfo = new TreeInfo();
		for(File itemFile:startDir.listFiles()){
			if(itemFile.isDirectory()){
				treeInfo.dirs.add(itemFile);
				treeInfo.addAll(recurseDirs(itemFile, regex));//递归
			}else{
				if(itemFile.getName().matches(regex)){
					treeInfo.files.add(itemFile);
				}
			}
		}
		return treeInfo;
	}
	public static void main(String[] args) {
		File[] files = Directory.local("e:\\lyfy", ".*.exe");
		for (File file : files) {
			System.out.println(file.getName() + "," + file.length()/1024 + "byte,"
					+ file.getParent().length()/1024/1024+"M");
		}
		
		TreeInfo treeinfo = walk("e:\\lyfy");
		for (File file : treeinfo) {
			System.out.println(file.toString());
		}
	}
}
