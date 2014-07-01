package com.andieguo.android;

import com.andieguo.android.View.OnClickListener;
import com.andieguo.android.View.OnLongClickListener;

public class Activity {
	static EditText text = null;
	public static void main(String[] args) {
		Button btn = new Button("提交按钮");
		text = new EditText("文本框");
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				System.out.println(v.getName()+"被点击了");
				text.setText("Hello");
			}
		});
		//如果有多个按钮点击事件，该如何实现监听更方便。
		btn.setOnLongClickListener(new OnLongClickListener() {//匿名内部类只能用一次
			
			@Override
			public void onLongClick(View v) {
				// TODO Auto-generated method stub
				System.out.println(v.getName()+"被长按了");
			}
		});
		btn.click();//模拟按钮点击操作；
		btn.longClick();//模拟按钮长按操作；
	}
}
