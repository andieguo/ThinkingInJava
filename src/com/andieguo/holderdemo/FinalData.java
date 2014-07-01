package com.andieguo.holderdemo;

public class FinalData {
	private final int valueOne = 3;
	private int valueTwo = 4;
	private final Value v1 = new Value(4);
	private Value v2 = new Value(10);
	private final int[] a = {1,2,3,4,5,6,7,8,9};
	private int[] b = {1,2,3,4,5,6,7,8,9};
	private static final int VAL_TWO = 3;
	
	public static void main(String[] args) {
		FinalData finalData = new FinalData();
		/*-----------基本类型测试------------------------------------*/
//		finalData.valueOne = 4;//valueOne是常量，无法修改
		finalData.valueTwo = 14;//valueTwo不是常量，可以修改
		
		/*-----------对象类型测试------------------------------------*/
//		finalData.v1 = new Value(5);//v1对象是final型常量，其引用是无法修改的。
		finalData.v2 = new Value(20);//v2对象final型常量，其引用可以修改。
		finalData.v1.i = 5;//v1对象的成员变量不是final型，可以修改
		
		/*-----------数组类型测试------------------------------------*/
//		finalData.a = new int[3];//数组a是final型，无法修改a的引用
		finalData.b = new int[13];//数组b不是final型，可以对其引用进行修改
		for(int i=0;i<finalData.a.length;i++) 
			finalData.a[i]++;//数组a内部数据是int型，不是final型，可以修改
		
		/*-----------static final类型测试------------------------------------*/
//		finalData.VAL_TWO = 4;
		//定义为private，只能被本类的方法调用；定义为static，则强调只有一份，且只被执行一次；定义为final，则说明它是一个常量，无法被修改。
		
	}
}
