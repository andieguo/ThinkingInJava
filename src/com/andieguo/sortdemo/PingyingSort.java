package com.andieguo.sortdemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PingyingSort {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		System.out.println("拼音首字母："+ PinyinUtils.getAllFirstLetter("我戬"));
		System.out.println("拼音："+PinyinUtils.getPinyin("我是一个乐观*开朗阳光向上积极进取#执着坚韧的人我是一个乐观*开朗阳光向上积极进取#执着坚韧的人我是一个乐观*开朗阳光向上积极进取#执着坚韧的人"));
		System.out.println("拼音："+PinyinUtils.getPinyin("我A"));
		System.out.println("拼音首字母："+PinyinUtils.getAlpha("我A戬"));
		System.out.println("拼音："+PinyinUtils.getPingYin("我是一个乐观开朗阳%光向上积极进取执着坚韧的人"));
		List<String> list = new ArrayList<String>();
		list.add("张三");
		list.add("李四");
		list.add("王五");
		list.add("555");
		list.add("戬");
		list.add("z四");
		list.add("A五");
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
