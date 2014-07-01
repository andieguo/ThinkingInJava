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
 * 这里展示了Java容器类库中的两种主要类型，Collection在每个槽中只能保存一个元素。Map在每个槽内保存了两个对象，即键与之相关联的值。
 * List，它以特定的顺序保存一组元素；
 * Set,元素不能重复；
 * Queue,只允许在容器的一端插入对象，并从另外一端移除对象
 * 使用容器提供的toString()方法即可生成可读性很好的结果。System.out.println(list)。调用的是list提供的toString()方法。
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
	 * Map:HashMap、TreeMap、LinkedHashMap
	 * Set:HashSet、TreeSet、LinkedHashSet
	 * @param args
	 */
	public static void main(String[] args) {
		//参数为容器，抽象出来的方法
		System.out.println(fill(new ArrayList<String>()));//按照被添加的顺序保存对象
		System.out.println(fill(new LinkedList<String>()));//按照被添加的顺序保存对象
		System.out.println(fill(new HashSet<String>()));//无序,无重复，存储顺序并无实际意义
		System.out.println(fill(new TreeSet<String>()));//无重复，按照比较结果的升序保存对象
		System.out.println(fill(new LinkedHashSet<String>()));//按照被添加的顺序保存对象
		System.out.println(fill(new HashMap<String,String>()));
		System.out.println(fill(new TreeMap<String,String>()));
		System.out.println(fill(new LinkedHashMap<String,String>()));	
		/**
		 *  [rat, cat, dog, dog]
			[rat, cat, dog, dog]
			[cat, dog, rat]
			[cat, dog, rat]//TreeSet：按字母的升序排序
			[rat, cat, dog]//LinkedHashSet：按添加的先后顺序排序
			{cat=Rags, dog=Spot, rat=Fuzzy}
			{cat=Rags, dog=Spot, rat=Fuzzy}
			{rat=Fuzzy, cat=Rags, dog=Spot}
		 */
		
	}

}
