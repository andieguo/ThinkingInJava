package com.andieguo.util;

import java.util.Random;
/**
 * 如果在创建过程中没有传递任何参数，那么Java就会将当前时间作为随机数生成器的种子，并由此在程序每一次执行时都产生不同的输出。
 * 通过创建Random对象时提供种子（用于随机数生成器的初始化值，随机数生成器对于特定的种子值总是产生相同的随机数序列），就可以在每一次执行
 * 程序时都生成相同的随机数。
 */
public class RandomDemo {
	public static void main(String[] args) {
		showRandom();
	}
	/**
	 * a、public Random() 该构造方法使用一个和当前系统时间对应的相对时间有关的数字作为种子数，然后使用这个种子数构造Random对象。
	 * public Random(long seed) 该构造方法可以通过制定一个种子数进行创建。 示例代码：
	 * Random r = new Random(); Random r1 = new Random(10); 再次强调：种子数只是随机算法的起源数字，和生成的随机数字的区间无关。
	 * 
	 * @param args
	 */
	public static void showRandom() {
		Random r = new Random(11);
		// 特别注意随机数据也有重复的时候
		for (int i = 0; i < 10; i++) {// 生成[0,9]到之间的整数
			System.out.print(r.nextInt(10)+" ");// 区别r1.nextInt(10)与r1.nextInt()
		}
		int n4 = r.nextInt(18) - 3;// 生成[-3,15)区间的整数
		int n5 = Math.abs(r.nextInt() % 18) - 3;// 生成[-3,15)区间的整数
		double d1 = r.nextDouble();// 生成[0,1.0)区间的小数
		double d2 = r.nextDouble() * 5;// 生成[0,5.0)区间的小数
	}
	
}
