package com.andieguo.stackdemo;

import java.util.LinkedList;

public class Stack<T> {
	private LinkedList<T> storage = new LinkedList<T>();//ΪʲôҪѡ��LinkedList,��Ϊ���ǰ���������Ⱥ�˳�������

	public void push(T v) {
		storage.addFirst(v);
	}

	public T peek() {//��ȡջ����Ԫ��
		return storage.getFirst();
	}

	public T pop() {//�Ƴ�������ջ����Ԫ��
		return storage.removeFirst();
	}

	public boolean empty() {
		return storage.isEmpty();
	}

	public String toString() {
		return storage.toString();
	}
}
