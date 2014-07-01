package com.andieguo.comparator;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Comparator可以看成一种算法的实现，将算法和数据分离，Comparator也可以在下面两种环境下使用：
 * 1、类的设计师没有考虑到比较问题而没有实现Comparable，可以通过Comparator来实现排序而不必改变对象本身
 * 2、可以使用多种排序标准，比如升序、降序等
 * 
 * @author Administrator
 * 
 */
public class CustomerComparator implements Comparator<Customer> {
	//返回负数表示o1 小于o2，返回0 表示o1和o2相等，返回正数表示o1大于o2	
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
