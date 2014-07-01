package com.andieguo.arraydemo;

import java.util.Arrays;
import java.util.Random;

public class ReturnArrayDemo {
	private static Random rand = new Random(47);
	static final String[] flower = { "玫瑰", "菊花", "桂花", "桃花", "栀子花", "梨花" };

	public static String[] flowerSet(int n) {
		if (n > flower.length) {
			throw new IllegalArgumentException("参数太大了");// 抛出异常
		}
		String[] results = new String[n];
		boolean[] picked = new boolean[flower.length];// 初始值全部为false
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
		 * [桂花, 梨花, 菊花, 栀子花, 玫瑰] [菊花, 玫瑰, 桃花, 梨花, 栀子花] [栀子花, 菊花, 桂花, 玫瑰, 桃花]
		 * [桂花, 菊花, 栀子花, 玫瑰, 桃花] [梨花, 玫瑰, 栀子花, 菊花, 桂花]
		 */
		for (int i = 0; i < 5; i++) {
			System.out.println(Arrays.toString(flowerSet(5)));
		}
		/**
		 * Exception in thread "main" java.lang.IllegalArgumentException: 参数太大了
		 * at com.andieguo.arraydemo.ReturnArrayDemo.flowerSet(ReturnArrayDemo.
		 * java:11) at
		 * com.andieguo.arraydemo.ReturnArrayDemo.main(ReturnArrayDemo.java:29)
		 */
		System.out.println(Arrays.toString(flowerSet(10)));
	}

}
