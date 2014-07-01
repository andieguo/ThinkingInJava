package com.andieguo.holderdemo;

import java.util.Arrays;
import java.util.List;

import com.andieguo.collectiondemo.Book;
/**
 * ����ʹ��Objectʵ�ֳ����κζ���
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
		String str = (String) holderObject.getObj();//����ת��
		System.out.println(str.length());
		
		HolderObject holderObject2 = new HolderObject(new Book("��ѧ",40.0));
		Book book = (Book) holderObject2.getObj();//����ת��
		System.out.println(book.getPrice());
		
		HolderObject holderObject3 = new HolderObject(Arrays.asList("A B C D".split(" ")));
		List<String> s = (List<String>) holderObject3.getObj();//����ת��
		System.out.println(s.get(0));
		
		Object obj = new String("I am happy");//����ת�ͣ����Ƕ�ʧ��String�����е����ԡ�//����ת�ͣ����Ƕ�ʧ��Book�����е�����,�޷�����getName(),getPrice()�������Ѿ���ʧ��
		System.out.println(obj);
		String string =(String) obj;//����ת��
		System.out.println(string.length());
	}
}
