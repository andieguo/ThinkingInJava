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
	public void doSth(){//�ײ㴥���ӿڻص�
		callBack.excute();
	}
}
