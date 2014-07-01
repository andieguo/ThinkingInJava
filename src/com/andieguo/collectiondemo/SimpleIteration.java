package com.andieguo.collectiondemo;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class SimpleIteration {
	public static void display(Iterator<Book> it) {
		while(it.hasNext()){
			System.out.print(it.next()+" ");
		}
		System.out.println();
	}
	/**
	 * 报异常：
	 * Exception in thread "main" java.lang.ClassCastException: 
	 * com.andieguo.collectiondemo.Book cannot be cast to java.lang.Comparable
	 * 解决：
	 * 原来TreeMap是有序的，有序就说明TreeMap中的每个Key元素都需要能比较，只有这样才能排序
	 * @param args
	 */
	public static void main(String[] args) {
		print();
		ArrayList<Book> books = Book.arrayList();
		LinkedList<Book> booksLL = new LinkedList<Book>(books);
		HashSet<Book> booksHS = new HashSet<Book>(books);
		//TreeSet需要对元素进行排序，故Book必须实现Comparable接口；
		TreeSet<Book> booksTS = new TreeSet<Book>(books);
		display(books.iterator());
		display(booksLL.iterator());
		display(booksHS.iterator());
		display(booksTS.iterator());
	}

	public static void print() {
		List<Book> books = Book.arrayList();
		Iterator<Book> it = books.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		for (Book book : books) {
			System.out.println(book);// 很关键：Book类重写了toString()方法
		}
		// for (int i = 0; i < 5; i++) {
		// it.next();
		// it.remove();
		// }
		// System.out.println(books);
	}
}
