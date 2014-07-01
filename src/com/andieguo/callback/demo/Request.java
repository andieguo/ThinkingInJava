package com.andieguo.callback.demo;
/**
 * �������뱻���÷������ڣ�ִ������������÷����󣬲ŷ���ִ����һ����䡣
 * ��ô������ajax�첽����һ�������������û��������Ӧ��ִ����һ�������?
 * @author Administrator
 *
 */
public class Request {
	private RequestContent rc;// ��������

	public Request(RequestContent rc) {
		this.rc = rc;
	}

	protected void start() { // ��ʼ����
		final Thread t = new Thread(new Runnable() {
			public void run() {
				try {
					rc.doSomeThing();// ��Ӧ����
				} catch (Exception e) {
					e.printStackTrace();
					rc.onFailure(); // ���ִ��ʧ��
				}
				rc.onSuccess();// ���ִ�гɹ�
			}
		});
		t.start();
	}
}
