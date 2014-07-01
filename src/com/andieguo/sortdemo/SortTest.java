package com.andieguo.sortdemo;

import java.text.Collator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class SortTest {

	public static void main(String[] args) {
		List<Client> clients = productClients();
		sort1();
		sort2();
		sort3(clients);
		sort4(clients);
		mapSort();
		setSort();
	}

	public static List<Client> productClients() {
		List<Client> clients = new ArrayList<Client>(){};
		clients.add(new Client("����", true, 21));
		clients.add(new Client("����", false, 21));// Z
		clients.add(new Client("����", false, 21));// W
		clients.add(new Client("����", false, 21));// L
		clients.add(new Client("����", true, 32));
		clients.add(new Client("����", false, 32));
		clients.add(new Client("����", true, 32));
		return clients;
	}
	/**
	 * ʹ��Arrays.sort(stringArr, String.CASE_INSENSITIVE_ORDER); // ��Сд������
	 */
	public static void sort1() {
		/** ���������ǽ��ַ������ң��Һ��д�Сд��ͷ���� */
		String[] stringArr = { "Baguette Laonnaise", "Bakers", "Baladi",
				"Balaton", "bandal", "Banon", "afuega'l Pitu", "Airag",
				"Airedale", "Aisy Cendre" };

		Arrays.sort(stringArr, String.CASE_INSENSITIVE_ORDER); // ��Сд������
		List<String> webNameArr = new ArrayList<String>();
		for (int i = 0; i < stringArr.length; i++) {
			webNameArr.add(stringArr[i]);
		}
		System.out.println(webNameArr.toString());//����ʹ�����ַ�ʽ��ӡ
	}
	/**
	 * ʹ�� Arrays.sort(newArray,Collator.getInstance(java.util.Locale.CHINA));  
	 */
	public static void sort2(){//����  ����  ����  ����  ����  �Ͼ�  ��ͷ  �人  ����  ��ɽ  ��ɽ
        // TODO Auto-generated method stub  
        String[] newArray={"��ɽ","��ͷ","����","����","����","�Ͼ�","�人","����","����","����"};  
        Arrays.sort(newArray,Collator.getInstance(java.util.Locale.CHINA));  
        for(String i:newArray){  
            System.out.println(i+"  ");  
        } 
	}
	/**
	 * ʹ��Collections.sort(clients, comparator);��д��Comparator����
	 * @param clients
	 */
	public static void sort3(List<Client> clients) {
		ComparatorClient comparator = new ComparatorClient();
		Collections.sort(clients, comparator);
		for (int i = 0; i < clients.size(); i++) {
			Client client = (Client) clients.get(i);
			System.out.println(client.getAge() + "," + client.getSex() + ","
					+ client.getName());
		}
		for(Client client:clients){
			System.out.println(client.getAge() + "," + client.getSex() + ","
					+ client.getName());
		}
	}
	/**
	 * ʹ��Collections.sort(clients, comparator);ʹ�������ڲ��ֻ࣬ʹ��һ��
	 * @param clients
	 */
	public static void sort4(List<Client> clients) {
		Collections.sort(clients, new Comparator<Client>() {
			public int compare(Client o1, Client o2) {
				String s1 = o1.getName();
				String s2 = o2.getName();
				return Collator.getInstance(Locale.CHINESE).compare(s1, s2);
			}
		});
		for (Client client : clients) {
			System.out.println(client.getName());
		}
	}
	
	public static void mapSort(){     
	     // ���ռ�ֵ����  
	     Map<String,String> sortMap= new TreeMap<String,String>(Collator.getInstance(java.util.Locale.CHINA));  
	     sortMap.put("��ɽ", "a");  
	     sortMap.put("����", "b");  
	     sortMap.put("����", "c");  
	     //ע�⣺ÿ�ζ�TreeMap����put()ʱ��TreeMap�����Զ���������compare(key,Entry.key)  
	     //����key��������     
	     Collection col = sortMap.keySet();  
	     Iterator it = col.iterator();  
	     while (it.hasNext()) {  
	       System.out.println(it.next());  
	     }  
	     for(String key:sortMap.keySet()){
	    	 System.out.println(key);
//	    	 System.out.println(sortMap.get(key));
//	    	 System.out.println(sortMap.values());
	     }
	     for(Entry<String, String> map:sortMap.entrySet()){
	    	 System.out.println(map.getKey());
	     }
	   }  
	/** 4��TreeSetʵ��Comparator��ʽ���� 
	 *    ��Ԫ�������߱��Ƚ���ʱ�����߾߱��ıȽ��Բ�������ģ���ʱ����Ҫ�� 
	 * ��������߱��Ƚ��ԡ� 
	 *    ���������������Ƚ���������Ϊ�������ݸ�TreeSet���ϵĹ��캯���� 
	 *  
	 * ���������򶼴���ʱ���ԱȽ���Ϊ��. 
	 *    ��ô����Ƚ���??����һ���ࣨ�˴�MyCompare��,ʵ��comparator�ӿ�,���� 
	 * compare����,��return 0;���ж�Ԫ���Ƿ���ͬ. 
	 *  
	 */  
	public static void setSort(){
//		Set<String> citys = new TreeSet<String>();//�Ϻ� ���� �人 ���� 
		Set<String> citys = new TreeSet<String>(Collator.getInstance(java.util.Locale.CHINA));
		citys.add("�人");
		citys.add("�人");
		citys.add("�Ϻ�");
		citys.add("����");
		citys.add("���");
		citys.add("����");
		citys.add("����");
		citys.add("����");
		citys.add("����");
		citys.add("֣��");//���� ���� ���� �Ϻ� ��� �人 ���� ֣�� ���� ,����ĸ����
		for(String city:citys){
			System.out.print(city+" ");
		}
	}
}
