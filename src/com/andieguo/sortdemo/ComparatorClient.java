package com.andieguo.sortdemo;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;
//java����--��Java�����е�Collections.sort������list��������ַ���
public class ComparatorClient implements Comparator {
	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		Client client1 = (Client) o1;
		Client client2 = (Client) o2;
		// ��һ�αȽ�����
		int i = client1.getAge().compareTo(client2.getAge());
		// ���������ͬ������еڶ��αȽ�
		if (i == 0) {
			//�ڶ��αȽ��Ա�
			int j = client1.getSex().compareTo(client2.getSex());
			//����Ա���ͬ��Ƚ�����
			if (j == 0) {
				return Collator.getInstance(Locale.CHINESE).compare(client1.getName(), client2.getName());
			}else{
				return j;
			}
		} else {
			return i;
		}
	}
}
