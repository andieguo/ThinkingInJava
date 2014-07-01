package com.andieguo.collectiondemo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
/**
 * ʹ����ǿforѭ���͵���������Map����
 * @author Administrator
 *
 */
public class MapTest {
    public static void main(String[] args) {
        Map<String,String> maps = new HashMap<String, String>();
        maps.put("age", "25");
        maps.put("name", "andy");
        maps.put("sex", "MAN");
        maps.put("sex", "Ů");//����
        maps.remove("sex");//�Ƴ�
        System.out.println("=========1��ͨ��key���Ϸ��ʣ���Key����Ȥ�����Է�����key��Ӧ��Valueֵ==============");
        for(String k:maps.keySet()){
            System.out.println(k+":"+maps.get(k));
        }
        System.out.println("=========2��ͨ��value���Ϸ���,ֻ��valueֵ����Ȥ���޷�����keyֵ==============");
        for(String value:maps.values()){
            System.out.println(value);
        }
        System.out.println("=========3��ͨ��Entry���Ϸ��ʣ���Entry����Ȥ�����Է�����key��Ӧ��Valueֵ==============");
        for(Entry entry:maps.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        System.out.println("=========1��ͨ������Key���Ϸ���==============");
        //maps.keySet()���ص���һ��Set<String>���ϣ����Կ��Զ�����е���
        Iterator<String> iterator = maps.keySet().iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            System.out.println(key+":"+maps.get(key));
        }
        System.out.println("=========2��ͨ������Values���Ϸ���==============");
        //maps.values()���ص���Collection<String>�����Կ��Զ������
        Iterator<String> iter= maps.values().iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
        System.out.println("=========3��ͨ������Entry���Ϸ���==============");
        //maps.entrySet()���ص���һ��Set<Entry<String, String>>�����Կ��Զ������
        Iterator<Entry<String, String>> it = maps.entrySet().iterator();
        while(it.hasNext()){
            Entry<String, String> entry = it.next();
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
}