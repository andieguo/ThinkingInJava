package com.andieguo.stackdemo;

import java.util.LinkedList;

public class Stack<T> {
	private LinkedList<T> storage = new LinkedList<T>();//为什么要选择LinkedList,因为它是按照输入的先后顺序排序的

	public void push(T v) {
		storage.addFirst(v);
	}

	public T peek() {//提取栈顶的元素
		return storage.getFirst();
	}

	public T pop() {//移除并返回栈顶的元素
		return storage.removeFirst();
	}

	public boolean empty() {
		return storage.isEmpty();
	}

	public String toString() {
		return storage.toString();
	}
}
