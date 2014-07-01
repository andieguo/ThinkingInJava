package com.andieguo.holderdemo;

import java.util.Arrays;
import java.util.List;

import com.andieguo.collectiondemo.Book;
/**
 * 该类使用Object实现持有任何对象
 * @author Administrator
 *
 */
public class HolderObject {
	private Object obj;

	public HolderObject(Object obj) {
		super();
		this.obj = obj;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}
	
	public static void main(String[] args) {
		HolderObject holderObject = new HolderObject("Hello");
		String str = (String) holderObject.getObj();//向下转型
		System.out.println(str.length());
		
		HolderObject holderObject2 = new HolderObject(new Book("数学",40.0));
		Book book = (Book) holderObject2.getObj();//向下转型
		System.out.println(book.getPrice());
		
		HolderObject holderObject3 = new HolderObject(Arrays.asList("A B C D".split(" ")));
		List<String> s = (List<String>) holderObject3.getObj();//向下转型
		System.out.println(s.get(0));
		
		Object obj = new String("I am happy");//向上转型，但是丢失了String类特有的属性。//向上转型，但是丢失了Book类特有的属性,无法调用getName(),getPrice()方法，已经丢失。
		System.out.println(obj);
		String string =(String) obj;//向下转型
		System.out.println(string.length());
	}
}
