package com.andieguo.callback.demo;

public class Test {
	public static void main(String[] args) {
		
		new Request(new RequestContent() {
			void doSomeThing() {
				System.out.println("doSomething");
			}

			void onSuccess() {
				System.out.println("override onSuccess");
			}
		}).start();
		
	}
}
