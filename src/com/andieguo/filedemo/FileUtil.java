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
	 * ������ file1���ļ�����������Ϊfile2���ļ�������a.txt������Ϊb.txt��
	 * ��������ǰ������Ѵ���b.txt��������������ɹ�������ִ�н������false�� ����ȷ��Ŀ���ļ���������֮ǰ�����ڣ����п��ܳɹ���
	 * 
	 * @param file
	 *            ԭ�ļ�
	 * @param newName
	 *            ���ļ���
	 */
	public static void rename(File file, String newName) {
		// newNameҪ����Ҫ�����
		if (file.exists()) {
			File newFile = new File(file.getParent(), newName);
			file.renameTo(newFile);
		}
	}
	/**
	 * �ƶ��ļ�
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
	 * �ƶ��ļ�
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
	 * ����һ���ļ������·�������ڣ������·�������ļ��У�����ļ������ڣ��򴴽��ļ���
	 * 
	 * @param path
	 *            �ļ���·��
	 * @param filename
	 *            �ļ���
	 * @return �����ɹ�����true;����ʧ�ܷ���false;
	 */
	public static boolean createFile(String path, String filename) {
		boolean flag = false;
		File file = new File(path, filename);
		File dir = new File(path);
		if (!dir.exists()) {// �ļ���������ִ�д���
			dir.mkdir();// �����ļ���
		}
		if (!file.exists()) {// �ļ��������򴴽��ļ�
			try {
				flag = file.createNewFile();// �����ļ��Ƿ�ɹ�
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	/**
	 * ����һ�����ļ�
	 * 
	 * @param file
	 *            �ļ�
	 * @return �����ɹ�����true;����ʧ�ܷ���false;
	 */
	public static boolean createFile(File file) {
		boolean flag = false;
		flag = createFile(file.getParent(), file.getName());
		return flag;
	}

	/**
	 * �����ɹ�����true��ʧ�ܷ���false
	 * 
	 * @param path
	 *            �ļ���·��
	 */
	public static boolean createDir(String path) {
		boolean flag = false;
		File dir = new File(path);
		if (!dir.exists()) {// �ļ��������򴴽�
			flag = dir.mkdir();
		}// ���ڲ�ִ�в���
		return flag;
	}

	/**
	 * ɾ�������ļ�
	 * 
	 * @param path
	 *            �ļ�·��
	 * @param name
	 *            �ļ���
	 * @return
	 */
	public static boolean delFile(String path, String name) {
		boolean flag = false;
		File file = new File(path, name);
		if (file.exists() && file.isFile()) {
			flag = file.delete();// ���file��һ��Ŀ¼�������Ŀ¼Ϊ�ղ���ɾ��
		}
		return flag;
	}

	/**
	 * ɾ�������ļ�
	 * 
	 * @param file
	 *            �ļ�����
	 * @return
	 */
	public static boolean delFile(File file) {
		boolean flag = false;
		// System.out.println(file.getAbsolutePath());
		flag = delFile(file.getParent(), file.getName());
		return flag;
	}

	/**
	 * �ݹ�ɾ���ļ����ļ���(���)
	 * 
	 * @param path
	 */
	public static void delDir(String path) {
		File file = new File(path);
		if (file.isDirectory()) {// ������ļ���
			File files[] = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				FileUtil.delDir(files[i].getAbsolutePath());// �ݹ�
			}
		}
		file.delete();
	}

	/**
	 * ��֤����·���Ƿ�Ϊ��ȷ��·����(Windowsϵͳ������ϵͳδʹ��)
	 * 
	 * @param path
	 *            ·��
	 * @return ��֤�ɹ�����true;��֤ʧ�ܷ���false
	 */
	public static boolean pathMatch(String path) {
		String reg = "[A-Za-z]:\\\\[^:?\"><*]*";
		return path.matches(reg);
	}

	public static void main(String[] args) {
		// System.out.println(pathMatch("e:\\e.\txt"));
		// FileUtil.createDir("e:\\a.txt");
		// System.out.println(FileUtil.createFile("e:\\bak", "b.txt"));// ��ν��ϵͳ�Ҳ���ָ��·��
		// FileUtil.delFile("e:\\e", "b.txt");
		// System.out.println(FileUtil.delFile(new File("e:\\c\\b.txt")));
		// FileUtil.delDir("e:\\c");
//		System.out.println(FileUtil.move(new File("e:\\a.txt"), new File("f:\\a.txt"), true));
		System.out.println(FileUtil.move("a.c", "f:\\", "e:\\", true));
	}

}
