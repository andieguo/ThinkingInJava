package com.andieguo.android;

import com.andieguo.android.View.OnClickListener;
import com.andieguo.android.View.OnLongClickListener;

public class Activity {
	static EditText text = null;
	public static void main(String[] args) {
		Button btn = new Button("�ύ��ť");
		text = new EditText("�ı���");
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				System.out.println(v.getName()+"�������");
				text.setText("Hello");
			}
		});
		//����ж����ť����¼��������ʵ�ּ��������㡣
		btn.setOnLongClickListener(new OnLongClickListener() {//�����ڲ���ֻ����һ��
			
			@Override
			public void onLongClick(View v) {
				// TODO Auto-generated method stub
				System.out.println(v.getName()+"��������");
			}
		});
		btn.click();//ģ�ⰴť���������
		btn.longClick();//ģ�ⰴť����������
	}
}
