package com.andieguo.stringdemo;

import java.util.Map;
import java.util.TreeMap;

public class SubStringDemo {

	/**
	 * ��key���顢value���������ַ���
	 * @param key key����
	 * @param value value����
	 * @return
	 */
	public static String packageData(String[] key,String[] value) {
		StringBuffer strBuffer = new StringBuffer("");
		for(int i=0;i<key.length;i++){
			strBuffer.append(key[i]);
			strBuffer.append("=");
			strBuffer.append(value[i]);
			strBuffer.append("\r\n");
		}
		strBuffer.substring(0, strBuffer.lastIndexOf("\r\n"));
		return strBuffer.toString();
	}
	/**
	 * ��maps��������Ϊ�ַ���
	 * @param maps maps����
	 * @return
	 */
	public static String packageData(Map<String,String> maps) {
		String[] keys = new String[maps.size()];
		String[] values = new String[maps.size()];
		return packageData(maps.keySet().toArray(keys),maps.values().toArray(values));
	}
	/**
	 * ���ַ������ΪMap����
	 * @param str
	 * @return
	 */
	public static Map<String,String> unpackageData(String str){
		Map<String,String> maps = new TreeMap<String, String>();
		String[] entrys = str.split("\r\n");
		for(int i=0;i<entrys.length;i++){
			String[] entry = entrys[i].split("=");
			maps.put(entry[0], entry[1]);
		}
		return maps;
	}
	
	public static void main(String[] args) {
		String str = SubStringDemo.packageData(new String[]{"data","age"}, new String[]{"12","13"});
		Map<String,String> maps = SubStringDemo.unpackageData(str);
		for(String key:maps.keySet()){
			System.out.println("key:"+key+",value:"+maps.get(key));
		}
		System.out.print(SubStringDemo.packageData(maps));
	}
}
