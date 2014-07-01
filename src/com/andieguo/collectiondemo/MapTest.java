package com.andieguo.collectiondemo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
/**
 * 使用增强for循环和迭代器遍历Map集合
 * @author Administrator
 *
 */
public class MapTest {
    public static void main(String[] args) {
        Map<String,String> maps = new HashMap<String, String>();
        maps.put("age", "25");
        maps.put("name", "andy");
        maps.put("sex", "MAN");
        maps.put("sex", "女");//覆盖
        maps.remove("sex");//移除
        System.out.println("=========1、通过key集合访问，对Key敢兴趣，可以访问与key对应的Value值==============");
        for(String k:maps.keySet()){
            System.out.println(k+":"+maps.get(k));
        }
        System.out.println("=========2、通过value集合访问,只对value值敢兴趣，无法访问key值==============");
        for(String value:maps.values()){
            System.out.println(value);
        }
        System.out.println("=========3、通过Entry集合访问，对Entry敢兴趣，可以访问与key对应的Value值==============");
        for(Entry entry:maps.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        System.out.println("=========1、通过迭代Key集合访问==============");
        //maps.keySet()返回的是一个Set<String>集合，所以可以对其进行迭代
        Iterator<String> iterator = maps.keySet().iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            System.out.println(key+":"+maps.get(key));
        }
        System.out.println("=========2、通过迭代Values集合访问==============");
        //maps.values()返回的是Collection<String>，所以可以对其迭代
        Iterator<String> iter= maps.values().iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
        System.out.println("=========3、通过迭代Entry集合访问==============");
        //maps.entrySet()返回的是一个Set<Entry<String, String>>，所以可以对其迭代
        Iterator<Entry<String, String>> it = maps.entrySet().iterator();
        while(it.hasNext()){
            Entry<String, String> entry = it.next();
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
}