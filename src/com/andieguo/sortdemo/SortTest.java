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
		clients.add(new Client("张三", true, 21));
		clients.add(new Client("张三", false, 21));// Z
		clients.add(new Client("王五", false, 21));// W
		clients.add(new Client("李三", false, 21));// L
		clients.add(new Client("李四", true, 32));
		clients.add(new Client("阿四", false, 32));
		clients.add(new Client("阿四", true, 32));
		return clients;
	}
	/**
	 * 使用Arrays.sort(stringArr, String.CASE_INSENSITIVE_ORDER); // 大小写不敏感
	 */
	public static void sort1() {
		/** 在这里我们将字符串打乱，且含有大小写开头不等 */
		String[] stringArr = { "Baguette Laonnaise", "Bakers", "Baladi",
				"Balaton", "bandal", "Banon", "afuega'l Pitu", "Airag",
				"Airedale", "Aisy Cendre" };

		Arrays.sort(stringArr, String.CASE_INSENSITIVE_ORDER); // 大小写不敏感
		List<String> webNameArr = new ArrayList<String>();
		for (int i = 0; i < stringArr.length; i++) {
			webNameArr.add(stringArr[i]);
		}
		System.out.println(webNameArr.toString());//集合使用这种方式打印
	}
	/**
	 * 使用 Arrays.sort(newArray,Collator.getInstance(java.util.Locale.CHINA));  
	 */
	public static void sort2(){//安庆  安阳  北方  北京  广州  南京  汕头  武汉  阳江  中山  中山
        // TODO Auto-generated method stub  
        String[] newArray={"中山","汕头","广州","安庆","阳江","南京","武汉","北京","安阳","北方"};  
        Arrays.sort(newArray,Collator.getInstance(java.util.Locale.CHINA));  
        for(String i:newArray){  
            System.out.println(i+"  ");  
        } 
	}
	/**
	 * 使用Collections.sort(clients, comparator);重写了Comparator方法
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
	 * 使用Collections.sort(clients, comparator);使用匿名内部类，只使用一次
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
	     // 按照键值排序  
	     Map<String,String> sortMap= new TreeMap<String,String>(Collator.getInstance(java.util.Locale.CHINA));  
	     sortMap.put("中山", "a");  
	     sortMap.put("广州", "b");  
	     sortMap.put("潮州", "c");  
	     //注意：每次对TreeMap进行put()时，TreeMap都会自动调用它的compare(key,Entry.key)  
	     //按照key进行排序     
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
	/** 4：TreeSet实现Comparator方式排序 
	 *    当元素自身不具备比较性时，或者具备的比较性不是所需的，这时就需要让 
	 * 容器自身具备比较性。 
	 *    定义了容器，将比较器对象作为参数传递给TreeSet集合的构造函数。 
	 *  
	 * 当两种排序都存在时，以比较器为主. 
	 *    怎么定义比较器??定义一个类（此处MyCompare）,实现comparator接口,覆盖 
	 * compare方法,以return 0;来判断元素是否相同. 
	 *  
	 */  
	public static void setSort(){
//		Set<String> citys = new TreeSet<String>();//上海 北京 武汉 重庆 
		Set<String> citys = new TreeSet<String>(Collator.getInstance(java.util.Locale.CHINA));
		citys.add("武汉");
		citys.add("武汉");
		citys.add("上海");
		citys.add("北京");
		citys.add("天津");
		citys.add("河南");
		citys.add("湖北");
		citys.add("云南");
		citys.add("重庆");
		citys.add("郑州");//北京 河南 湖北 上海 天津 武汉 云南 郑州 重庆 ,按字母排序
		for(String city:citys){
			System.out.print(city+" ");
		}
	}
}
