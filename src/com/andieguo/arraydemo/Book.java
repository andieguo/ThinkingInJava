package com.andieguo.arraydemo;

public class Book {
	private static long counter;
	private final long id = counter++;//ÿ��ʵ�����������1
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "book_"+id;
	}
}
