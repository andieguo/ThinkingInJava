package com.andieguo.callback;

public class Test {
	
	public static void main(String[] args) {
		test1();
		test2();
	}

	public static void test2() {
		FooBar fooBar = new FooBar();
		fooBar.setCallBack(new ICallBack() {
			
			@Override
			public void excute() {
				// TODO Auto-generated method stub
				System.out.println("ִ���˻ص�����");
			}
		});
	}

	public static void test1() {
		FooBar fooBar = new FooBar(new ICallBack() {//�ϲ�ʵ�ֻص�����
			
			@Override
			public void excute() {
				// TODO Auto-generated method stub
				System.out.println("ִ�лص�");
			}
		});
		fooBar.doSth();
	}
}
