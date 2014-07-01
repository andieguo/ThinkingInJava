package com.andieguo.collectiondemo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
/**
 * ����չʾ��Java��������е�������Ҫ���ͣ�Collection��ÿ������ֻ�ܱ���һ��Ԫ�ء�Map��ÿ�����ڱ������������󣬼�����֮�������ֵ��
 * List�������ض���˳�򱣴�һ��Ԫ�أ�
 * Set,Ԫ�ز����ظ���
 * Queue,ֻ������������һ�˲�����󣬲�������һ���Ƴ�����
 * ʹ�������ṩ��toString()�����������ɿɶ��ԺܺõĽ����System.out.println(list)�����õ���list�ṩ��toString()������
 * @author Administrator
 *
 */
public class PrintingContainers {
	public static Collection<String> fill(Collection<String> collection) {
		collection.add("rat");
		collection.add("cat");
		collection.add("dog");
		collection.add("dog");
		return collection;
	}

	public static Map<String, String> fill(Map<String, String> map) {
		map.put("rat", "Fuzzy");
		map.put("cat", "Rags");
		map.put("dog", "Bosco");
		map.put("dog", "Spot");
		return map;
	}
	/**
	 * Map:HashMap��TreeMap��LinkedHashMap
	 * Set:HashSet��TreeSet��LinkedHashSet
	 * @param args
	 */
	public static void main(String[] args) {
		//����Ϊ��������������ķ���
		System.out.println(fill(new ArrayList<String>()));//���ձ���ӵ�˳�򱣴����
		System.out.println(fill(new LinkedList<String>()));//���ձ���ӵ�˳�򱣴����
		System.out.println(fill(new HashSet<String>()));//����,���ظ����洢˳����ʵ������
		System.out.println(fill(new TreeSet<String>()));//���ظ������ձȽϽ�������򱣴����
		System.out.println(fill(new LinkedHashSet<String>()));//���ձ���ӵ�˳�򱣴����
		System.out.println(fill(new HashMap<String,String>()));
		System.out.println(fill(new TreeMap<String,String>()));
		System.out.println(fill(new LinkedHashMap<String,String>()));	
		/**
		 *  [rat, cat, dog, dog]
			[rat, cat, dog, dog]
			[cat, dog, rat]
			[cat, dog, rat]//TreeSet������ĸ����������
			[rat, cat, dog]//LinkedHashSet������ӵ��Ⱥ�˳������
			{cat=Rags, dog=Spot, rat=Fuzzy}
			{cat=Rags, dog=Spot, rat=Fuzzy}
			{rat=Fuzzy, cat=Rags, dog=Spot}
		 */
		
	}

}
