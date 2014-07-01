package com.andieguo.collectiondemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
/**
 * ��java.util���е�Arrays��Collections�����кܶ�ʵ�õķ�����������һ��Collection�����һ��Ԫ�ء�
 * Arrays.asList()��������һ�����������һ�����ŷָ���Ԫ���б�ʹ�ÿɱ��������������ת��Ϊһ��List���󡣣���һ�����顢Ԫ���б�----->List����
 * @author Administrator
 *
 */
public class AddingGroups {
	public static void main(String[] args) {
		
		//Collection�Ĺ��������Խ�������һ��Collection�������������ʼ��,��˿���ʹ��Arrays.asList()��Ϊ�������������һ�����롣
		Collection<Integer> collection = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));//��������ʼ��
		collection.add(11);//�������
		collection.remove(1);//�����Ƴ�
		System.out.println(collection);//��ӡ����
		
		Integer[] moreInts = {6,7,8,9,10};//����
		//Arrays.asList(moreInts)��һ������ת��Ϊһ��List����
		//����һ��������Ԫ�ص�Collection��Ȼ�����collection.addAll()���Ԫ�ظ��ӷ��㣬���������ѡ��ʽ��
		collection.addAll(Arrays.asList(moreInts));//������һЩ
		System.out.println(collection);//��ӡ����
		
		Collections.addAll(collection, 11,12,13,14,15);
		System.out.println(collection);
		Collections.addAll(collection,moreInts);//������һЩ
		System.out.println(collection);
		
		//����ֱ��ʹ��Arrays.asList()����������䵱��List����������������£���ײ��ʾ�������飬��˲��ܵ����ߴ硣�����ͼʹ��add()��remove()����
		//�������б�����ӻ�ɾ��Ԫ�أ��Ϳ�������ȥ�ı�����ߴ�ĳ��ԣ�����㽫������ʱ��á�UnsupportedOperationException(��֧��)������
		List<Integer> list = Arrays.asList(16,17,18,19,20);//�ܹؼ�
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
