package com.andieguo.filedemo;

import java.io.File;
import java.io.IOException;

public class FileUtil {

	public static double getSize(File file, String ext) {
		if (file.exists()) {
			if (ext.equals("byte")) {
				return file.length() / 1024;
			} else if (ext.equals("M")) {
				return file.length() / 1024 / 1024;
			} else if (ext.equals("G")) {
				return file.length() / 1024 / 1024 / 1024;
			} else {
				return file.length();
			}
		} else {
			return -1;
		}
	}

	public static String getSizeString(File file, String ext) {
		return getSize(file, ext) + ext;
	}

	/**
	 * 重命名 file1的文件名将重命名为file2的文件名，即a.txt重命名为b.txt。
	 * 在重命名前，如果已存在b.txt，则重命名不会成功，方法执行结果返回false。 必须确保目标文件在重命名之前不存在，才有可能成功。
	 * 
	 * @param file
	 *            原文件
	 * @param newName
	 *            新文件名
	 */
	public static void rename(File file, String newName) {
		// newName要满足要求才行
		if (file.exists()) {
			File newFile = new File(file.getParent(), newName);
			file.renameTo(newFile);
		}
	}
	/**
	 * 移动文件
	 * @param filename
	 * @param oldpath
	 * @param newpath
	 * @param cover
	 * @return
	 */
	public static boolean move(String filename, String oldpath, String newpath,
			boolean cover) {
		boolean flag = false;
		if (!oldpath.equals(newpath)) {
			File oldfile = new File(oldpath, filename);
			File newfile = new File(newpath, filename);
			if (newfile.exists()) {
				if (cover) {
					flag = oldfile.renameTo(newfile);
				} else
					return false;
			} else {
				flag = oldfile.renameTo(newfile);
			}
		}
		return flag;
	}
	/**
	 * 移动文件
	 * @param oldfile
	 * @param newfile
	 * @param cover
	 * @return
	 */
	public static boolean move(File oldfile, File newfile, boolean cover) {
		boolean flag = false;
		if (newfile.exists()) {
			if (cover) {
				flag = oldfile.renameTo(newfile);
			} else
				return false;
		} else {
			flag = oldfile.renameTo(newfile);
		}
		return flag;
	}

	/**
	 * 创建一个文件，如果路径不存在，则根据路径创建文件夹；如果文件不存在，则创建文件。
	 * 
	 * @param path
	 *            文件夹路径
	 * @param filename
	 *            文件名
	 * @return 创建成功返回true;创建失败返回false;
	 */
	public static boolean createFile(String path, String filename) {
		boolean flag = false;
		File file = new File(path, filename);
		File dir = new File(path);
		if (!dir.exists()) {// 文件不存在则执行创建
			dir.mkdir();// 创建文件夹
		}
		if (!file.exists()) {// 文件不存在则创建文件
			try {
				flag = file.createNewFile();// 创建文件是否成功
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	/**
	 * 创建一个新文件
	 * 
	 * @param file
	 *            文件
	 * @return 创建成功返回true;创建失败返回false;
	 */
	public static boolean createFile(File file) {
		boolean flag = false;
		flag = createFile(file.getParent(), file.getName());
		return flag;
	}

	/**
	 * 创建成功返回true；失败返回false
	 * 
	 * @param path
	 *            文件夹路径
	 */
	public static boolean createDir(String path) {
		boolean flag = false;
		File dir = new File(path);
		if (!dir.exists()) {// 文件不存在则创建
			flag = dir.mkdir();
		}// 存在不执行操作
		return flag;
	}

	/**
	 * 删除单个文件
	 * 
	 * @param path
	 *            文件路径
	 * @param name
	 *            文件名
	 * @return
	 */
	public static boolean delFile(String path, String name) {
		boolean flag = false;
		File file = new File(path, name);
		if (file.exists() && file.isFile()) {
			flag = file.delete();// 如果file是一个目录，则必须目录为空才能删除
		}
		return flag;
	}

	/**
	 * 删除单个文件
	 * 
	 * @param file
	 *            文件类型
	 * @return
	 */
	public static boolean delFile(File file) {
		boolean flag = false;
		// System.out.println(file.getAbsolutePath());
		flag = delFile(file.getParent(), file.getName());
		return flag;
	}

	/**
	 * 递归删除文件和文件夹(最简单)
	 * 
	 * @param path
	 */
	public static void delDir(String path) {
		File file = new File(path);
		if (file.isDirectory()) {// 如果是文件夹
			File files[] = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				FileUtil.delDir(files[i].getAbsolutePath());// 递归
			}
		}
		file.delete();
	}

	/**
	 * 验证传入路径是否为正确的路径名(Windows系统，其他系统未使用)
	 * 
	 * @param path
	 *            路径
	 * @return 验证成功返回true;验证失败返回false
	 */
	public static boolean pathMatch(String path) {
		String reg = "[A-Za-z]:\\\\[^:?\"><*]*";
		return path.matches(reg);
	}

	public static void main(String[] args) {
		// System.out.println(pathMatch("e:\\e.\txt"));
		// FileUtil.createDir("e:\\a.txt");
		// System.out.println(FileUtil.createFile("e:\\bak", "b.txt"));// 如何解决系统找不到指定路径
		// FileUtil.delFile("e:\\e", "b.txt");
		// System.out.println(FileUtil.delFile(new File("e:\\c\\b.txt")));
		// FileUtil.delDir("e:\\c");
//		System.out.println(FileUtil.move(new File("e:\\a.txt"), new File("f:\\a.txt"), true));
		System.out.println(FileUtil.move("a.c", "f:\\", "e:\\", true));
	}

}
