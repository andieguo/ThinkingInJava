package com.andieguo.collectiondemo;

import java.util.ArrayList;


public class Book implements Comparable<Book> {
	private String name;
	private Double price;

	public Book(String name, Double price) {
		super();
		this.name = name;
		this.price = price;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Book(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	@Override
	public String toString() {
		return "Book [name=" + name + ", price=" + price + "]";
	}

	public static ArrayList<Book> arrayList(){
		ArrayList<Book> books = new ArrayList<Book>();
		books.add(new Book("语文",20.0));
		books.add(new Book("数学",25.0));
		books.add(new Book("政治",10.0));
		books.add(new Book("化学",22.0));
		books.add(new Book("物理",22.0));
		return books;
	}
	public static void main(String[] args) {
		
		System.out.println(Book.arrayList());
	}

	@Override
	public int compareTo(Book o) {
		// TODO Auto-generated method stub
		return  ((this.price == o.price)?0:(this.price>o.price?1:-1));
	}
}
