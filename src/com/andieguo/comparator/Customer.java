package com.andieguo.comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
/**
 * һ����ʵ����Camparable�ӿ�����������Ķ���֮���ǿ����໥�Ƚϵģ�����������ɵļ��ϾͿ���ֱ��ʹ��sort��������
 * @author Administrator
 *
 */
public class Customer implements Comparable<Customer> {
	private String name;
	private Integer age;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Customer(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Customer [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Customer o) {
		// TODO Auto-generated method stub
		return this.age-o.getAge();
	}
	//ʵ��Comparable�ӿ�
	public static void main(String[] args) {
		//�����������
		Customer[] customers = new Customer[]{new Customer("andy", 23),new Customer("jack", 25),new Customer("duf", 12)};
		Arrays.sort(customers);//ʵ��Comparable�ӿڵĶ����б������飩����ͨ��Collections.sort��Arrays.sort�����Զ�����
		for(Customer customer:customers){
			System.out.println(customer);
		}
		//��Լ�������
		List<Customer> listCustomers = Arrays.asList(customers);
		Collections.sort(listCustomers);
		for(Customer customer:listCustomers){
			System.out.println(customer);
		}
	}

}
