package com.andieguo.iterabledemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class ForeachDemo {
	public static void printIterator(Iterator<String> it){
		while(it.hasNext()){
			System.out.print(it.next()+" ");
		}
		System.out.println();
	}
	
	public static void printCollection(Collection<String> colleciton){
		printIterator(colleciton.iterator());
	}
	public static void forEachCollection(Collection<String> colleciton){
		for(String str:colleciton){////���ձ���ӵ�˳�򱣴����
			System.out.print(str+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		listArray();
		System.out.println();
		listCollection();
		System.out.println();
		iterableCollection();
	}
	public static void iterableCollection() {
		String[] array = {"A","A","B","E","F","G","C","D"};
		printCollection(new ArrayList<String>(Arrays.asList(array)));//A A B E F G C D 
		printCollection(new LinkedList<String>(Arrays.asList(array)));//���ձ���ӵ�˳�򱣴���� //A A B E F G C D 
		printCollection(new HashSet<String>(Arrays.asList(array)));//���ظ�������,�洢˳����ʵ������//D E F G A B C 
		printCollection(new TreeSet<String>(Arrays.asList(array)));//���ظ������ձȽϽ�������򱣴����//A B C D E F G 
		printCollection(new LinkedHashSet<String>(Arrays.asList(array)));//���ظ������ձ���ӵ�˳�򱣴����//A B E F G C D 
	}


	public static void listCollection() {
		String[] array = {"A","A","B","E","F","G","C","D"};
		forEachCollection(new ArrayList<String>(Arrays.asList(array)));//A A B E F G C D 
		forEachCollection(new LinkedList<String>(Arrays.asList(array)));//���ձ���ӵ�˳�򱣴���� //A A B E F G C D 
		forEachCollection(new HashSet<String>(Arrays.asList(array)));//���ظ�������,�洢˳����ʵ������//D E F G A B C 
		forEachCollection(new TreeSet<String>(Arrays.asList(array)));//���ظ������ձȽϽ�������򱣴����//A B C D E F G 
		forEachCollection(new LinkedHashSet<String>(Arrays.asList(array)));//���ظ������ձ���ӵ�˳�򱣴����//A B E F G C D 
	}
	

	public static void listArray() {
		String[] array = {"A","A","B","E","F","G","C","D"};
		for(String str:array){
			System.out.print(str+" ");
		}/**output:A B C D E F G **/
		System.out.println();
	}
}
