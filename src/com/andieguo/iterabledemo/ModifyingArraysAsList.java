package com.andieguo.iterabledemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ModifyingArraysAsList {
	/**
	 *  before:[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
		after:[6, 1, 4, 8, 10, 9, 7, 5, 3, 2]
		array:[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
		------------------------------------
		before2:[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
		after2:[8, 9, 2, 3, 6, 10, 7, 5, 1, 4]
		array:[8, 9, 2, 3, 6, 10, 7, 5, 1, 4]

	 * @param args
	 */
	public static void main(String[] args) {
		//为什么Random rand = new Random(47);不会有变化
		Random rand = new Random();
		Integer[] ia = {1,2,3,4,5,6,7,8,9,10};
		//为什么要进行2层封装
		//第一种情况中，Arrays.asList()的输出被传递给了ArrayList()的构造器，这样创建一个引用
		//ia元素的ArrayList,因此打乱这些引用不会修改数组。
		//第二种情况中，直接使用Arrays.asList(ia)的输出结果，这种打乱就会修改ia数组的顺序。
		//意识到Arrays.asList()产生的List对象会使用底层数组作为其物理实现是很重要的。
		//只要你执行的操作会修改这个List，并且你不想原来的数组被修改，那么你就应该在另外一个容器中创建一个副本。
		List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(ia));
		System.out.println("before:"+list1);
		Collections.shuffle(list1,rand);
		System.out.println("after:"+list1);
		System.out.println("array:"+Arrays.toString(ia));
		System.out.println("------------------------------------");
		List<Integer> list2 = Arrays.asList(ia);
		System.out.println("before2:"+list2);
		Collections.shuffle(list2,rand);
		System.out.println("after2:"+list2);
		System.out.println("array:"+Arrays.toString(ia));
	}
}
