package com.andieguo.callback.liwang;

public class Test {
	
	public static void main(String[] args) {
		Li li = new Li();
		Wang wang = new Wang(li);
		wang.askQuestion("1+1=?");
	}
}
