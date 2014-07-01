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
	 * �ͻ��˳�����Զ�ȡA��B�������󣬵�������ȴ�޷�������ֵ��ֵ��A��B,��Ϊfinal���͵�A��B�ڹ��췽���ﱻ��ʼ��֮�󣬲����ٶ��丳ֵ�޸ġ�
	 * @param args
	 */
	public static void main(String[] args) {
		TwoTuple<String, Double> book = new TwoTuple<String, Double>("��ѧ", 40.0);
		System.out.println(book.getA()+","+book.getB());
		//book.a = "����";//�޷��޸�
	}
}
