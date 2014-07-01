package com.andieguo.comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
/**
 * 一个类实现了Camparable接口则表明这个类的对象之间是可以相互比较的，这个类对象组成的集合就可以直接使用sort方法排序。
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
	//实现Comparable接口
	public static void main(String[] args) {
		//针对数组排序
		Customer[] customers = new Customer[]{new Customer("andy", 23),new Customer("jack", 25),new Customer("duf", 12)};
		Arrays.sort(customers);//实现Comparable接口的对象列表（和数组）可以通过Collections.sort或Arrays.sort进行自动排序。
		for(Customer customer:customers){
			System.out.println(customer);
		}
		//针对集合排序
		List<Customer> listCustomers = Arrays.asList(customers);
		Collections.sort(listCustomers);
		for(Customer customer:listCustomers){
			System.out.println(customer);
		}
	}

}
