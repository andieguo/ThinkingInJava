package com.andieguo.comparator;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Comparator���Կ���һ���㷨��ʵ�֣����㷨�����ݷ��룬ComparatorҲ�������������ֻ�����ʹ�ã�
 * 1��������ʦû�п��ǵ��Ƚ������û��ʵ��Comparable������ͨ��Comparator��ʵ����������ظı������
 * 2������ʹ�ö��������׼���������򡢽����
 * 
 * @author Administrator
 * 
 */
public class CustomerComparator implements Comparator<Customer> {
	//���ظ�����ʾo1 С��o2������0 ��ʾo1��o2��ȣ�����������ʾo1����o2	
	@Override
	public int compare(Customer o1, Customer o2) {
		// TODO Auto-generated method stub
		return (o1.getAge()==o2.getAge()?0:(o1.getAge()<o2.getAge()?-1:1));
	}

	public static void main(String[] args) {
		Customer[] customers = new Customer[] { 
				new Customer("andy", 23),
				new Customer("jack", 25), 
				new Customer("duf", 12) };
		Arrays.sort(customers, new CustomerComparator());
		for (Customer customer : customers) {
			System.out.println(customer);
		}
	}
}
