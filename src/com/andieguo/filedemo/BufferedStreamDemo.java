package com.andieguo.filedemo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * BufferedStream的使用
 * BufferedOutputStream的数据成员buf是一个位数组，默认为512字节。当使用write()方法写入数据时，实际上会先将数据写至buf中，
 * 当buf已满时才会实现给定的OutputStream对象的write()方法，将buf数据写至目的地，而不是每次都对目的地作写入的动作。
 * 
 * 
 * 为了确保缓冲区中的数据一定被写出至目的地，建议最后执行flush()将缓冲区中的数据全部写出目的流中。这个范例的执行结果与范例14.5是相同的。
 * 
 * BufferedInputStream和BufferedOutputStream并没有改变InputStream或
 * OutputStream的行为，读入或写出时的动作还是InputStream和OutputStream负责
 * 。BufferedInputStream和BufferedOutputStream只是在操作对应的方法之前
 * ，动态地为它们加上一些额外功能(像缓冲区功能)，在这里是以文件存取流为例
 * ，实际上可以在其他流对象上也使用BufferedInputStream和BufferedOutputStream功能。
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
	 * copy无乱码
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
			bufferedOutputStream.flush();// 将缓冲区中的数据全部写出
			bufferedInputStream.close();
			bufferedOutputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("找不到文件");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
