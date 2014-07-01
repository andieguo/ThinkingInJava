package com.andieguo.comparator;

public class Person {
	private String firstname;
	private String lastname;
	private Boolean sex;
	private Integer age;
	
	public Person(String firstname, String lastname, Boolean sex, Integer age) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.sex = sex;
		this.age = age;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Boolean getSex() {
		return sex;
	}
	public void setSex(Boolean sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [firstname=" + firstname + ", lastname=" + lastname
				+ ", sex=" + (sex.booleanValue()?"ÄÐ":"Å®") + ", age=" + age + "]";
	}
	
}
