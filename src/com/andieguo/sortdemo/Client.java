package com.andieguo.sortdemo;

public class Client {
	private String name;
	private Boolean sex;

	private Integer age;

	public Client(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Client(String name, Boolean sex, Integer age) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
	}

	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

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

}
