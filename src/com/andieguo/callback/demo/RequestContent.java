package com.andieguo.callback.demo;

public abstract class RequestContent {
	void onSuccess() { // 执行成功的动作。用户可以覆盖此方法
		System.out.println("onSuccess");
	}

	void onFailure() { // 执行失败的动作。用户可以覆盖此方法
		System.out.println("onFailure");
	}

	abstract void doSomeThing(); // 用户必须实现这个抽象方法，告诉子线程要做什么
}
