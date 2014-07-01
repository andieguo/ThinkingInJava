package com.andieguo.iterabledemo;

import java.util.Iterator;
/**
 * 实现了Iterable<T>接口之后，既适用于foreach遍历，又适用于使用while循环进行迭代
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
	 * 返回一个Iterator<T>对象
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
		IterablerClass<String> iterablerClass = new IterablerClass<String>(new String[]{"武汉","深圳","上海","北京","重庆"});
		System.out.println("-------------使用foreach输出-----------------");
		for(String s:iterablerClass){//iterablerClass是一个Iterable<T>实例
			System.out.print(s+" ");
		}
		System.out.println("\n-----------使用iterator输出----------------");
		Iterator<String> it = iterablerClass.iterator();
		while(it.hasNext()){
			System.out.print(it.next()+" ");
		}
	}
}
