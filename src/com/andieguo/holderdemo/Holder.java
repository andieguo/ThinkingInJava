package com.andieguo.holderdemo;

import java.util.Arrays;
import java.util.List;

import com.andieguo.collectiondemo.Book;
/**
 * Holder类使用泛型可以持有任何类型的对象
 * @author Administrator
 *
 * @param <T>
 */
public class Holder<T> {
	private T t = null;

	public Holder(T t) {this.t = t;}

	public T getT() {return t;}

	public void setT(T t) {this.t = t;}
	
	public static void main(String[] args) {
		System.out.println(Arrays.asList("boo:aad:foo".split("a")));
		System.out.println(Arrays.asList("boo:and:foo".split(":")));
		
		Holder<String> holder = new Holder<String>("Hello");
		String str = holder.getT();
		System.out.println("字符串的长度："+str.length()+",字符串是："+str+"");
		
		Holder<Book> holder1 = new Holder<Book>(new Book("数学",40.0));
		System.out.println("书名："+holder1.getT().getName()+",价格："+holder1.getT().getPrice());
		
		Holder<List<String>> holder2 = new Holder<List<String>>(Arrays.asList("A B C D E F".split(" ")));
		System.out.println("第一个字符串是："+holder2.getT().get(0));
		
	}
}
