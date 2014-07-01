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
				System.out.println("执行了回调方法");
			}
		});
	}

	public static void test1() {
		FooBar fooBar = new FooBar(new ICallBack() {//上层实现回调函数
			
			@Override
			public void excute() {
				// TODO Auto-generated method stub
				System.out.println("执行回调");
			}
		});
		fooBar.doSth();
	}
}
