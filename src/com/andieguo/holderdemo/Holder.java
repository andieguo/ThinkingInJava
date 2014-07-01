package com.andieguo.holderdemo;

import java.util.Arrays;
import java.util.List;

import com.andieguo.collectiondemo.Book;
/**
 * Holder��ʹ�÷��Ϳ��Գ����κ����͵Ķ���
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
		System.out.println("�ַ����ĳ��ȣ�"+str.length()+",�ַ����ǣ�"+str+"");
		
		Holder<Book> holder1 = new Holder<Book>(new Book("��ѧ",40.0));
		System.out.println("������"+holder1.getT().getName()+",�۸�"+holder1.getT().getPrice());
		
		Holder<List<String>> holder2 = new Holder<List<String>>(Arrays.asList("A B C D E F".split(" ")));
		System.out.println("��һ���ַ����ǣ�"+holder2.getT().get(0));
		
	}
}
