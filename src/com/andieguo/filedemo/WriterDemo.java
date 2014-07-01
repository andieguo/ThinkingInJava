package com.andieguo.filedemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
/**
 * FileReader��FileWriter��ʹ��
 * @author Administrator
 *
 */
public class WriterDemo {
	public static void main(String[] args) {
		write();
		read();
	}

	public static void read() {
		File file = new File("e:\\lyfy\\a.txt");
		try {
			Reader in = new FileReader(file);
			char cbuf[] = new char[2];
			int temp = 0;
			while((temp=in.read(cbuf))!=-1){
				System.out.print(String.valueOf(cbuf));//��char[]ת��ΪString
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void write() {
		File file = new File("e:\\lyfy\\a.txt");
		try {
			Writer out = new FileWriter(file,true);//׷��
			out.write("\r\tdajiahao0000000");//����
			//���е����ݶ���д�뵽�ڴ滺�����У��ر�out��ʱ���ǿ�ƽ�������������д���ļ���
			out.flush();//ǿ������ջ������е�����
			out.close();//���ر�out���޷�д���ݵ��ļ��е�
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
