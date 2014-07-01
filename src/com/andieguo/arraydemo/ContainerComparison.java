package com.andieguo.arraydemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContainerComparison {
	public static void main(String[] args) {
		arrayTest();
		listTest(5);
		/**��̬����������Ϊ�������*/
		printArray(new Book[]{new Book(),new Book(),new Book()});
	}

	private static void printArray(Book[] books) {
		// TODO Auto-generated method stub
		for(Book book:books){
			System.out.println("��"+book.toString()+"����");
		}
	}

	public static void listTest(int n) {
		List<Book> bookList = new ArrayList<Book>();
		for (int i = 0; i < n; i++) {
			bookList.add(new Book());
		}
		System.out.println(bookList);//��ӡlist����
		System.out.println(bookList.get(4));
	}

	public static void arrayTest() {
		Book[] books = new Book[10];//��ʼ��һ������(������װ����Book��������)
		for (int i = 0; i < 5; i++) {
			books[i] = new Book();//Ϊ�����������
		}
		System.out.println(Arrays.toString(books));//��ӡ����
		System.out.println(books[4]);
	}
}
