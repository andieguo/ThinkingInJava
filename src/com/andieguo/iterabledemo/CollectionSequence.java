package com.andieguo.iterabledemo;

import java.util.AbstractCollection;


import java.util.Arrays;

import java.util.Iterator;

import com.andieguo.collectiondemo.Book;


public class CollectionSequence<T> extends AbstractCollection<T> {//������
	private T[] array = null;
	
	public CollectionSequence(T[] t){
		this.array = t ;
	}
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<T>(){
			private int index = 0; 
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return index < array.length;
			}

			@Override
			public T next() {
				// TODO Auto-generated method stub
				return array[index++];
			}

			@Override
			public void remove() {
				// TODO Auto-generated method stub
				throw new UnsupportedOperationException();
			}};
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return array.length;
	}

	public static void main(String[] args) {
		printType(new String[]{"HELLO","EVERYBODY","WELCOME"});
		printType(new Integer[]{1,2,3,4,5,6});
		printType(new Book[]{new Book("��ѧ"),new Book("Ӣ��")});
		printObject(new String[]{"HELLO","EVERYBODY","WELCOME"});//Ҳ�ܹ�ִ�У�������ת��ΪObject֮��ʧ��String���������е�����
	}

	public static <W> void printType(W[] w) {//����ʹ�÷��ͣ��ڷ��ز���֮ǰ���<W>
		System.out.println("-------------ʹ��foreach���-----------------");
		CollectionSequence<W> cs = new CollectionSequence<W>(w);
		for(W t:cs){
			System.out.print(t+" ");
		}
		System.out.println("\n-----------ʹ��iterator���----------------");
		Iterator<W> it = cs.iterator();
		while(it.hasNext()){
			System.out.print(it.next()+" ");
		}
		System.out.println();
	}
	
	public static  void printObject(Object[] obj) {//����ʹ�÷��ͣ��ڷ��ز���֮ǰ���<W>
		System.out.println("-------------ʹ��foreach���-----------------");
		CollectionSequence<Object> cs = new CollectionSequence<Object>(obj);
		for(Object o:cs){
			System.out.print(o+" ");
		}
		System.out.println("\n-----------ʹ��iterator���----------------");
		Iterator<Object> it = cs.iterator();
		while(it.hasNext()){
			System.out.print(it.next()+" ");
		}
		System.out.println();
	}
}
