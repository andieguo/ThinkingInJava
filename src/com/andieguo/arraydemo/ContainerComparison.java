package com.andieguo.arraydemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContainerComparison {
	public static void main(String[] args) {
		arrayTest();
		listTest(5);
		/**动态创建数组作为输入参数*/
		printArray(new Book[]{new Book(),new Book(),new Book()});
	}

	private static void printArray(Book[] books) {
		// TODO Auto-generated method stub
		for(Book book:books){
			System.out.println("第"+book.toString()+"本书");
		}
	}

	public static void listTest(int n) {
		List<Book> bookList = new ArrayList<Book>();
		for (int i = 0; i < n; i++) {
			bookList.add(new Book());
		}
		System.out.println(bookList);//打印list集合
		System.out.println(bookList.get(4));
	}

	public static void arrayTest() {
		Book[] books = new Book[10];//初始化一个数组(数组内装的是Book类型数据)
		for (int i = 0; i < 5; i++) {
			books[i] = new Book();//为数组添加数据
		}
		System.out.println(Arrays.toString(books));//打印数组
		System.out.println(books[4]);
	}
}
