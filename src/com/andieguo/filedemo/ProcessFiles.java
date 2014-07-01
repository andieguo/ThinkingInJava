package com.andieguo.filedemo;

import java.io.File;
import java.io.IOException;
import com.andieguo.sortdemo.PinyinUtils;
/**
 * ʵ��process�����ᴩ�������ļ�֮�У�ÿ�ҵ�һ���ļ�ִ��һ��processs����
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
	 * ���Ա������Ŀ¼
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
			strategy.process(file.getCanonicalFile());//���ش˳���·�����Ĺ淶��ʽ��
		}
	}
	/**
	 * ������
	 * @param args ���飺new String[] {"e:\\lyfy","e:\\360Downloads"}
	 */
	public static void main(String[] args) {
		new ProcessFiles(new Strategy() {
			@Override
			public void process(File file) {//���ơ��ƶ����������Ȳ���
				FileUtil.rename(file,PinyinUtils.getPingYin(file.getName()));
			}
		}, "mp3").start(args);
	}
}
