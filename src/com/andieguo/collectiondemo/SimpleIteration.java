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
	 * ���쳣��
	 * Exception in thread "main" java.lang.ClassCastException: 
	 * com.andieguo.collectiondemo.Book cannot be cast to java.lang.Comparable
	 * �����
	 * ԭ��TreeMap������ģ������˵��TreeMap�е�ÿ��KeyԪ�ض���Ҫ�ܱȽϣ�ֻ��������������
	 * @param args
	 */
	public static void main(String[] args) {
		print();
		ArrayList<Book> books = Book.arrayList();
		LinkedList<Book> booksLL = new LinkedList<Book>(books);
		HashSet<Book> booksHS = new HashSet<Book>(books);
		//TreeSet��Ҫ��Ԫ�ؽ������򣬹�Book����ʵ��Comparable�ӿڣ�
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
			System.out.println(book);// �ܹؼ���Book����д��toString()����
		}
		// for (int i = 0; i < 5; i++) {
		// it.next();
		// it.remove();
		// }
		// System.out.println(books);
	}
}
