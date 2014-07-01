package com.andieguo.collectiondemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
/**
 * 在java.util包中的Arrays和Collections类中有很多实用的方法，可以在一个Collection中添加一组元素。
 * Arrays.asList()方法接收一个数组或者是一个逗号分隔的元素列表（使用可变参数），并将其转换为一个List对象。（将一个数组、元素列表----->List对象）
 * @author Administrator
 *
 */
public class AddingGroups {
	public static void main(String[] args) {
		
		//Collection的构造器可以接受另外一个Collection，用它将自身初始化,因此可以使用Arrays.asList()来为这个构造器产生一个输入。
		Collection<Integer> collection = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));//声明并初始化
		collection.add(11);//可以添加
		collection.remove(1);//可以移除
		System.out.println(collection);//打印容器
		
		Integer[] moreInts = {6,7,8,9,10};//数组
		//Arrays.asList(moreInts)将一个数组转换为一个List对象
		//构建一个不包含元素的Collection，然后调用collection.addAll()添加元素更加方便，因此它是首选方式。
		collection.addAll(Arrays.asList(moreInts));//更常用一些
		System.out.println(collection);//打印容器
		
		Collections.addAll(collection, 11,12,13,14,15);
		System.out.println(collection);
		Collections.addAll(collection,moreInts);//更常用一些
		System.out.println(collection);
		
		//可以直接使用Arrays.asList()的输出，将其当做List，但是在这种情况下，其底层表示的是数组，因此不能调整尺寸。如果试图使用add()或remove()方法
		//在这种列表中添加或删除元素，就可能引发去改变数组尺寸的尝试，因此你将在运行时获得“UnsupportedOperationException(不支持)”错误
		List<Integer> list = Arrays.asList(16,17,18,19,20);//很关键
		list.set(1, 99);
		list.remove(1);//java.lang.UnsupportedOperationException
		list.add(88);//java.lang.UnsupportedOperationException
		System.out.println(list);
		
		
		/**
		 * 	[1, 2, 3, 4, 5]
			[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
			[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]
			[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 6, 7, 8, 9, 10]
			[16, 99, 18, 19, 20]
		 */
	}
}
