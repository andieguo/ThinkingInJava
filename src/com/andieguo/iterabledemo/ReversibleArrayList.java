package com.andieguo.iterabledemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class ReversibleArrayList<T> extends ArrayList<T> {
	private static final long serialVersionUID = 2843552489593809340L;

	public ReversibleArrayList(Collection<T> c){
		super(c);
	}
	/**
	 * 注意区别new Iterable<T>方法与new Iterator<T>()方法
	 * 使用Iterable能够适用于foreach。使用Iterator能适用于while循环迭代
	 * @return
	 */
	public Iterable<T> reversed(){
		return new Iterable<T>(){
			@Override
			public Iterator<T> iterator() {
				// TODO Auto-generated method stub
				return new Iterator<T>() {
					int current = size()-1;//size()是父类ArrayList里的方法
					@Override
					public boolean hasNext() {
						// TODO Auto-generated method stub
						return current > -1;
					}

					@Override
					public T next() {
						// TODO Auto-generated method stub
						return get(current--);
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
		ReversibleArrayList<String> ral = new ReversibleArrayList<String>(Arrays.asList("one two three four five six".split(" ")));
		for(String str:ral){
			System.out.print(str+" ");
		}
		System.out.println();
		for(String str:ral.reversed()){
			System.out.print(str+" ");
		}
	}
}
