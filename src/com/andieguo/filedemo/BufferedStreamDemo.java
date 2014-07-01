package com.andieguo.filedemo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * BufferedStream��ʹ��
 * BufferedOutputStream�����ݳ�Աbuf��һ��λ���飬Ĭ��Ϊ512�ֽڡ���ʹ��write()����д������ʱ��ʵ���ϻ��Ƚ�����д��buf�У�
 * ��buf����ʱ�Ż�ʵ�ָ�����OutputStream�����write()��������buf����д��Ŀ�ĵأ�������ÿ�ζ���Ŀ�ĵ���д��Ķ�����
 * 
 * 
 * Ϊ��ȷ���������е�����һ����д����Ŀ�ĵأ��������ִ��flush()���������е�����ȫ��д��Ŀ�����С����������ִ�н���뷶��14.5����ͬ�ġ�
 * 
 * BufferedInputStream��BufferedOutputStream��û�иı�InputStream��
 * OutputStream����Ϊ�������д��ʱ�Ķ�������InputStream��OutputStream����
 * ��BufferedInputStream��BufferedOutputStreamֻ���ڲ�����Ӧ�ķ���֮ǰ
 * ����̬��Ϊ���Ǽ���һЩ���⹦��(�񻺳�������)�������������ļ���ȡ��Ϊ��
 * ��ʵ���Ͽ�����������������Ҳʹ��BufferedInputStream��BufferedOutputStream���ܡ�
 * 
 * @author Administrator
 * 
 */
public class BufferedStreamDemo {

	public static void main(String[] args) {
		copy(new String[] { "e:\\lyfy\\c.txt", "e:\\lyfy\\b.txt" });
	}

	/**
	 * BufferedInputStream = FileInputStream + buf
	 * copy������
	 * 
	 * @param args
	 */
	public static void copy(String[] args) {
		byte[] data = new byte[1024];
		File srcFile = new File(args[0]);
		File desFile = new File(args[1]);
		try {
			BufferedInputStream bufferedInputStream = new BufferedInputStream(
					new FileInputStream(srcFile));
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
					new FileOutputStream(desFile));
			while (bufferedInputStream.read(data) != -1) {
				bufferedOutputStream.write(data);
			}
			bufferedOutputStream.flush();// ���������е�����ȫ��д��
			bufferedInputStream.close();
			bufferedOutputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("�Ҳ����ļ�");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
