package com.andieguo.callback.demo;
/**
 * 程序会进入被调用方法体内，执行完这个被调用方法后，才返回执行下一条语句。
 * 怎么做到像ajax异步请求一样，发送请求后，没等请求响应就执行下一条语句呢?
 * @author Administrator
 *
 */
public class Request {
	private RequestContent rc;// 请求主体

	public Request(RequestContent rc) {
		this.rc = rc;
	}

	protected void start() { // 开始请求
		final Thread t = new Thread(new Runnable() {
			public void run() {
				try {
					rc.doSomeThing();// 响应请求
				} catch (Exception e) {
					e.printStackTrace();
					rc.onFailure(); // 如果执行失败
				}
				rc.onSuccess();// 如果执行成功
			}
		});
		t.start();
	}
}
