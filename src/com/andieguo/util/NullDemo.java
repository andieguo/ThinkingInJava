package com.andieguo.util;

/**
 * Java 空字符串与Null的区别
 * 1、String str = "";说明str是一个空字符串，它在内存中是存在的，分配了内存空间.它可以使用Object对象中的方法(如"".toString();"".equals())；
 * 	 String str = null;// null表示没有分配内存空间，在内存中是不存在的，没有分配内存空间.它不可以使用Object对象中的方法(如"".toString();"".equals())；使用后会报错java.lang.NullPointerException
 * 2 对象用equals比较，null用等号比较;
 * @author Administrator
 *
 */
/**
 * Java空字符串与null区别：
 * 
 * 1、类型 null表示的是一个对象的值，而并不是一个字符串。例如声明一个对象的引用，String a = null ;
 * ""表示的是一个空字符串，也就是说它的长度为0。例如声明一个字符串String str = "" ;
 * 
 * 2、内存分配 String str = null ; 表示声明一个字符串对象的引用，但指向为null，也就是说还没有指向任何的内存空间； String
 * str = ""; 表示声明一个字符串类型的引用，其值为""空字符串，这个str引用指向的是空字符串的内存空间；
 * 
 * 在java中变量和引用变量是存在栈中（stack），而对象（new产生的）都是存放在堆中（heap）：
 * 
 * 就如下：
 * 
 * String str = new String("abc") ;
 * 
 * ps：=左边的是存放在栈中（stack），=右边是存放在堆中（heap）。
 * 
 * @author Administrator
 * 
 */
public class NullDemo {
	/**
	 * 而在Java里面有两个比较相等的方法一个是用“==”，另一个是String 里面的equals()方法，两个的区别是，前者比较的是地址，后者比较的
	 * 是内容。
	 * 
	 * 例如你写了这样的一个语句 String str1，str2； 那就是定义了两个指向不同String实例的句柄，现在他们都是指向null
	 * 的所以str1==str2==null，此时你不能用length()方法，因为，他们 都没有指向具体的对象，如果调用这个方法的话，会返回一个
	 * NullPointerException。 之后，如果你写了这样的语句 str1=new String();
	 * 那么str1将指向一个具体的String实例，所以str1!=str2,str1!=null，
	 * 而且更重要的是str1！=""，因为""与str1所指的是两个不同的地址。 但方法str1.length()的返回值就是0了，也就是字符串为空。
	 * 同样即使你再这样写 str2=new String(); 这个时候依然是str1！=str2，因为他们指向的是两个不同的地址，
	 * 但如果你用str1.equals(str2)的话，返回值就是true，因为他们的内 容相同，都为空。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();
	}

	public static void test() {
		String str = new String();// 默认是空串
		if (str.equals("")) {
			System.out.println("默认是空串");
		}
	}

	public static void test2() {

		// ""是一个字符串(String).它在内存中是存在的.它可以使用Object对象中的方法(如"".toString();"".equals())
		String str1 = "";// ""分配了内存 空间，表示声明一个字符串类型的引用，其值为""空字符串，这个str引用指向的是空字符串的内存空间；

		// 而null它是一个空对象.在内存中是不存在的.它不可以使用Object对象中的方法
		String str = null;// null表示没有分配内存空间
		
		System.out.println(str1.equals(""));// 对象用equals比较，null用等号比较
		System.out.println(str == null);// 对象用equals比较，null用等号比较
		
		System.out.println(str.equals(null));//调用null的字符串的方法会抛空指针java.lang.NullPointerException异常。

		if (str != null &&!(str.length() > 0)) { // 先判断是不是对象，如果是，再判断是不是空字符串
			// do something
		}
		
		if (str != null && !str.equals("")){
			// do something
		}
	}
}
