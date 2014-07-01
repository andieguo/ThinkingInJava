package com.andieguo.iterabledemo;

import java.util.Map.Entry;

public class EnvironmentVariables {
	public static void main(String[] args) {
		for(Entry entry:System.getenv().entrySet()){
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
	}
}
