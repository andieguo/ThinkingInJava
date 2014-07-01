package com.andieguo.filedemo;

import java.io.File;
import java.io.IOException;
import com.andieguo.sortdemo.PinyinUtils;
/**
 * 实现process操作贯穿于搜索文件之中，每找到一个文件执行一次processs操作
 * @author Administrator
 *
 */
public class ProcessFiles {
	public interface Strategy {
		void process(File file);
	}

	private Strategy strategy;
	private String ext;

	public ProcessFiles(Strategy strategy, String ext) {
		this.strategy = strategy;
		this.ext = ext;
	}

	/**
	 * 可以遍历多个目录
	 * 
	 * @param args
	 */
	public void start(String[] args) {
		try {
			if (args.length == 0) {
				processDirectoryTree(new File("e:\\test"));
			} else {
				for (String arg : args) {
					File fileArg = new File(arg);
					if (fileArg.isDirectory()) {
						processDirectoryTree(fileArg);
					} else {
						if (!arg.endsWith("." + ext)) {
							arg += "." + ext;
						}
						strategy.process(new File(arg).getCanonicalFile());
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void processDirectoryTree(File root) throws IOException {
		// TODO Auto-generated method stub
		for (File file : Directory.walk(root.getAbsolutePath(), ".*\\." + ext)) {
			strategy.process(file.getCanonicalFile());//返回此抽象路径名的规范形式。
		}
	}
	/**
	 * 主方法
	 * @param args 数组：new String[] {"e:\\lyfy","e:\\360Downloads"}
	 */
	public static void main(String[] args) {
		new ProcessFiles(new Strategy() {
			@Override
			public void process(File file) {//复制、移动、重命名等操作
				FileUtil.rename(file,PinyinUtils.getPingYin(file.getName()));
			}
		}, "mp3").start(args);
	}
}
