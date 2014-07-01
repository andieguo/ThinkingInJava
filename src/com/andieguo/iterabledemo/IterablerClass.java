package com.andieguo.iterabledemo;

import java.util.Iterator;
/**
 * ʵ����Iterable<T>�ӿ�֮�󣬼�������foreach��������������ʹ��whileѭ�����е���
 * @author Administrator
 *
 * @param <T>
 */
public class IterablerClass<T> implements Iterable<T>{
	private T[] array = null;
	
	public IterablerClass(T[] t){
		this.array = t ;
	}
	/**
	 * ����һ��Iterator<T>����
	 */
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<T>() {
			private Integer index = 0;
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return index<array.length;
			}

			@Override
			public T next() {
				// TODO Auto-generated method stub
				return array[index++];
			}

			@Override
			public void remove() {
				// TODO Auto-generated method stub
			}
		};
	}
	public static void main(String[] args) {
		IterablerClass<String> iterablerClass = new IterablerClass<String>(new String[]{"�人","����","�Ϻ�","����","����"});
		System.out.println("-------------ʹ��foreach���-----------------");
		for(String s:iterablerClass){//iterablerClass��һ��Iterable<T>ʵ��
			System.out.print(s+" ");
		}
		System.out.println("\n-----------ʹ��iterator���----------------");
		Iterator<String> it = iterablerClass.iterator();
		while(it.hasNext()){
			System.out.print(it.next()+" ");
		}
	}
}
