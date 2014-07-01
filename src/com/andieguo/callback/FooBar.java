package com.andieguo.callback;

public class FooBar {
	private ICallBack callBack;

	public void setCallBack(ICallBack callBack) {
		this.callBack = callBack;
	}
	public FooBar() {
		super();
	}
	public FooBar(ICallBack callBack) {
		super();
		this.callBack = callBack;
	}
	public void doSth(){//底层触发接口回调
		callBack.excute();
	}
}
