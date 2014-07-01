package com.andieguo.arraydemo;

import java.util.Arrays;
import java.util.Random;

public class ReturnArrayDemo {
	private static Random rand = new Random(47);
	static final String[] flower = { "õ��", "�ջ�", "��", "�һ�", "���ӻ�", "�滨" };

	public static String[] flowerSet(int n) {
		if (n > flower.length) {
			throw new IllegalArgumentException("����̫����");// �׳��쳣
		}
		String[] results = new String[n];
		boolean[] picked = new boolean[flower.length];// ��ʼֵȫ��Ϊfalse
		for (int i = 0; i < n; i++) {
			int t;
			do
				t = rand.nextInt(flower.length);
			while (picked[t]);
			results[i] = flower[t];
			picked[t] = true;
		}
		return results;
	}

	public static void main(String[] args) {
		/**
		 * [��, �滨, �ջ�, ���ӻ�, õ��] [�ջ�, õ��, �һ�, �滨, ���ӻ�] [���ӻ�, �ջ�, ��, õ��, �һ�]
		 * [��, �ջ�, ���ӻ�, õ��, �һ�] [�滨, õ��, ���ӻ�, �ջ�, ��]
		 */
		for (int i = 0; i < 5; i++) {
			System.out.println(Arrays.toString(flowerSet(5)));
		}
		/**
		 * Exception in thread "main" java.lang.IllegalArgumentException: ����̫����
		 * at com.andieguo.arraydemo.ReturnArrayDemo.flowerSet(ReturnArrayDemo.
		 * java:11) at
		 * com.andieguo.arraydemo.ReturnArrayDemo.main(ReturnArrayDemo.java:29)
		 */
		System.out.println(Arrays.toString(flowerSet(10)));
	}

}
