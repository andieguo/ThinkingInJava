package com.andieguo.bignumber;

public interface Caculate {
	/**
	 * 将两个大整数相乘
	 * @param first
	 * @param second
	 * @return 得到的结果用字符串表示
	 */
	abstract String multiply(String first, String second) ;
	/**
	 * 将两个大整数相加
	 * @param first
	 * @param second 
	 * @return 得到的结果用字符串表示
	 */
	abstract  String add(String first, String second);
	/**
	 * 将两个大整数相减
	 * @param first
	 * @param second
	 * @return 得到的结果用字符串表示
	 */
	abstract  String reduce(String first, String second);
	/**
	 * 将两个大整数相乘并计算出余数
	 * @param numberOne
	 * @param numberTwo
	 * @return 得到的结果用字符数组储存
	 */
	abstract String[] divide(final String numberOne,final  String numberTwo);

}
