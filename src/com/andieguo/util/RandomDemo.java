package com.andieguo.util;

import java.util.Random;
/**
 * ����ڴ���������û�д����κβ�������ôJava�ͻὫ��ǰʱ����Ϊ����������������ӣ����ɴ��ڳ���ÿһ��ִ��ʱ��������ͬ�������
 * ͨ������Random����ʱ�ṩ���ӣ�����������������ĳ�ʼ��ֵ������������������ض�������ֵ���ǲ�����ͬ����������У����Ϳ�����ÿһ��ִ��
 * ����ʱ��������ͬ���������
 */
public class RandomDemo {
	public static void main(String[] args) {
		showRandom();
	}
	/**
	 * a��public Random() �ù��췽��ʹ��һ���͵�ǰϵͳʱ���Ӧ�����ʱ���йص�������Ϊ��������Ȼ��ʹ���������������Random����
	 * public Random(long seed) �ù��췽������ͨ���ƶ�һ�����������д����� ʾ�����룺
	 * Random r = new Random(); Random r1 = new Random(10); �ٴ�ǿ����������ֻ������㷨����Դ���֣������ɵ�������ֵ������޹ء�
	 * 
	 * @param args
	 */
	public static void showRandom() {
		Random r = new Random(11);
		// �ر�ע���������Ҳ���ظ���ʱ��
		for (int i = 0; i < 10; i++) {// ����[0,9]��֮�������
			System.out.print(r.nextInt(10)+" ");// ����r1.nextInt(10)��r1.nextInt()
		}
		int n4 = r.nextInt(18) - 3;// ����[-3,15)���������
		int n5 = Math.abs(r.nextInt() % 18) - 3;// ����[-3,15)���������
		double d1 = r.nextDouble();// ����[0,1.0)�����С��
		double d2 = r.nextDouble() * 5;// ����[0,5.0)�����С��
	}
	
}
