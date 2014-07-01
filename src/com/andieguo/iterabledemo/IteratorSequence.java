package com.andieguo.iterabledemo;

import java.util.Iterator;

public class IteratorSequence<T> {
	private T[] array = null;
	public IteratorSequence(T[] array){
		this.array = array;
	}
	/**
	 * ����һ��Iterable<T>����
	 * @return
	 */
	public Iterable<T> iterator(){//Iterable�ܹ�����foreach
		return new Iterable<T>(){
			@Override
			public Iterator<T> iterator() {
				// TODO Auto-generated method stub
				return new Iterator<T>() {
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
					}
				};
			}};
	}
	public static void main(String[] args) {
		IteratorSequence<String> iteratorSequence = new IteratorSequence<String>(new String[]{"A","B","C"});
		for(String str:iteratorSequence.iterator()){//iteratorSequence.iterator()���ص���һ��Iterable<T>ʵ����֧��foreachѭ��
			System.out.print(str+" ");
		}
	}
}
