package com.andieguo.sortdemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PingyingSort {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		System.out.println("ƴ������ĸ��"+ PinyinUtils.getAllFirstLetter("���"));
		System.out.println("ƴ����"+PinyinUtils.getPinyin("����һ���ֹ�*�����������ϻ�����ȡ#ִ�ż��͵�������һ���ֹ�*�����������ϻ�����ȡ#ִ�ż��͵�������һ���ֹ�*�����������ϻ�����ȡ#ִ�ż��͵���"));
		System.out.println("ƴ����"+PinyinUtils.getPinyin("��A"));
		System.out.println("ƴ������ĸ��"+PinyinUtils.getAlpha("��A�"));
		System.out.println("ƴ����"+PinyinUtils.getPingYin("����һ���ֹۿ�����%�����ϻ�����ȡִ�ż��͵���"));
		List<String> list = new ArrayList<String>();
		list.add("����");
		list.add("����");
		list.add("����");
		list.add("555");
		list.add("�");
		list.add("z��");
		list.add("A��");
		Collections.sort(list, new Comparator() {
			public int compare(Object _o1, Object _o2) {
				return (PinyinUtils.getAllFirstLetter(((String) _o1)
						.substring(0, 1)).compareTo(PinyinUtils
						.getAllFirstLetter(((String) _o2).substring(0, 1))));
			}
		});
		for (String str : list) {
			System.out.println(str);
		}
	}
}
