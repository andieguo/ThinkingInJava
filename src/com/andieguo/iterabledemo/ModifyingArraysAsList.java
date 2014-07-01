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
		//ΪʲôRandom rand = new Random(47);�����б仯
		Random rand = new Random();
		Integer[] ia = {1,2,3,4,5,6,7,8,9,10};
		//ΪʲôҪ����2���װ
		//��һ������У�Arrays.asList()����������ݸ���ArrayList()�Ĺ���������������һ������
		//iaԪ�ص�ArrayList,��˴�����Щ���ò����޸����顣
		//�ڶ�������У�ֱ��ʹ��Arrays.asList(ia)�������������ִ��Ҿͻ��޸�ia�����˳��
		//��ʶ��Arrays.asList()������List�����ʹ�õײ�������Ϊ������ʵ���Ǻ���Ҫ�ġ�
		//ֻҪ��ִ�еĲ������޸����List�������㲻��ԭ�������鱻�޸ģ���ô���Ӧ��������һ�������д���һ��������
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
