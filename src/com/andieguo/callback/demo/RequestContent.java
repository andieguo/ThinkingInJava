package com.andieguo.callback.demo;

public abstract class RequestContent {
	void onSuccess() { // ִ�гɹ��Ķ������û����Ը��Ǵ˷���
		System.out.println("onSuccess");
	}

	void onFailure() { // ִ��ʧ�ܵĶ������û����Ը��Ǵ˷���
		System.out.println("onFailure");
	}

	abstract void doSomeThing(); // �û�����ʵ��������󷽷����������߳�Ҫ��ʲô
}
