package com.andieguo.holderdemo;

public class TwoTuple<A,B> {
	public final A a;
	public final B b;
	public TwoTuple(A a, B b) {
		this.a = a;
		this.b = b;
	}
	
	public A getA() {
		return a;
	}

	public B getB() {
		return b;
	}
	/**
	 * 客户端程序可以读取A、B两个对象，但是它们却无法将其他值赋值给A、B,因为final类型的A、B在构造方法里被初始化之后，不能再对其赋值修改。
	 * @param args
	 */
	public static void main(String[] args) {
		TwoTuple<String, Double> book = new TwoTuple<String, Double>("数学", 40.0);
		System.out.println(book.getA()+","+book.getB());
		//book.a = "语文";//无法修改
	}
}
