package com.andieguo.yanghui;

import java.math.BigInteger;
import java.util.Scanner;
/**
 * java�������������㣺BigInteger���÷��Ĳ���demo
 * ���⣺java ����������
 * @author Administrator
 *
 */
public class BigIntegerTest {

	public static void main(String[] args) {
		// test3();
		test4();
		// test();
	}
	
	public static void test4(){
		BigInteger a = BigInteger.valueOf(1223232132);
		System.out.println(a.add(BigInteger.valueOf(1000000000)));
		System.out.println(a.remainder(BigInteger.valueOf(2)).equals(BigInteger.valueOf(0)));//�ж��Ƿ�Ϊż��
	}

	public static void test3() {
		BigInteger result ;
		BigInteger n = new BigInteger("1111111111");
		BigInteger m = new BigInteger("2222222222");
		result = n.add(m);// �����׳���,���֮��Ҫ��ֵ��n
		System.out.println(result);
	}

	public static void test2() {
		Scanner scanner = new Scanner(System.in);
		BigInteger n = null;
		while (scanner.hasNext()) {
			n = scanner.nextBigInteger();
			n = n.add(new BigInteger("2222222222"));
			System.out.println(n);
		}
	}

	public static void test() {
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			String str1 = cin.next(), str2 = cin.next();
			BigInteger a = new BigInteger(str1), b = new BigInteger(str2);
			System.out.println(a.add(b));
		}
	}

}
