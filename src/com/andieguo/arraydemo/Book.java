package com.andieguo.arraydemo;

public class Book {
	private static long counter;
	private final long id = counter++;//每次实例化，都会加1
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "book_"+id;
	}
}
