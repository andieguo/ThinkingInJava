package com.andieguo.iterabledemo;

import java.util.Iterator;

public class IteratorSequence<T> {
	private T[] array = null;
	public IteratorSequence(T[] array){
		this.array = array;
	}
	/**
	 * 返回一个Iterable<T>对象
	 * @return
	 */
	public Iterable<T> iterator(){//Iterable能够用于foreach
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
		for(String str:iteratorSequence.iterator()){//iteratorSequence.iterator()返回的是一个Iterable<T>实例，支持foreach循环
			System.out.print(str+" ");
		}
	}
}
