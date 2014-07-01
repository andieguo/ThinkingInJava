package com.andieguo.sortdemo;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;
//java基础--用Java集合中的Collections.sort方法对list排序的两种方法
public class ComparatorClient implements Comparator {
	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		Client client1 = (Client) o1;
		Client client2 = (Client) o2;
		// 第一次比较年龄
		int i = client1.getAge().compareTo(client2.getAge());
		// 如果年龄相同，则进行第二次比较
		if (i == 0) {
			//第二次比较性别
			int j = client1.getSex().compareTo(client2.getSex());
			//如果性别相同则比较姓名
			if (j == 0) {
				return Collator.getInstance(Locale.CHINESE).compare(client1.getName(), client2.getName());
			}else{
				return j;
			}
		} else {
			return i;
		}
	}
}
