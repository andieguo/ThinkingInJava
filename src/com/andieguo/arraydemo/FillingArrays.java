package com.andieguo.arraydemo;

import java.util.Arrays;

public class FillingArrays {
	public static void main(String[] args) {
		int size = 6;
		boolean[] a1 = new boolean[size];
		byte[] a2 = new byte[size];
		char[] a3 = new char[size];
		short[] a4 = new short[size];
		int[] a5 = new int[size];
		long[] a6 = new long[size];
		Arrays.fill(a1, true);//只能用一個值填充各個位置
		Arrays.fill(a2, (byte) 11);
		Arrays.fill(a3, 'x');
		Arrays.fill(a4, (short) 17);
		Arrays.fill(a5, 19);
		Arrays.fill(a6, 21);
		System.out.println(Arrays.toString(a1));
		System.out.println(Arrays.toString(a2));
		System.out.println(Arrays.toString(a3));
		System.out.println(Arrays.toString(a4));
		System.out.println(Arrays.toString(a5));
		System.out.println(Arrays.toString(a6));
		/**
		 * [true, true, true, true, true, true] 
		 * [11, 11, 11, 11, 11, 11] 
		 * [x, x,x, x, x, x] 
		 * [17, 17, 17, 17, 17, 17] 
		 * [19, 19, 19, 19, 19, 19] 
		 * [21,21, 21, 21, 21, 21]
		 */

	}
}
