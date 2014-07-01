package com.andieguo.comparator;

import java.util.Arrays;
import java.util.Comparator;

public class PersonComparators implements Comparator<Person> {

	public int compare(String o1, String o2) {
		String s1 = o1;
		String s2 = o2;
		int len1 = s1.length();
		int len2 = s2.length();
		int n = Math.min(len1, len2);
		char v1[] = s1.toCharArray();
		char v2[] = s2.toCharArray();
		int pos = 0;
		while (n-- != 0) {
			char c1 = v1[pos];
			char c2 = v2[pos];
			if (c1 != c2) {
				return c1 - c2;
			}
			pos++;
		}
		return len1 - len2;
	}

	public int compare(Integer o1, Integer o2) {//比较年龄(从小到大)
		int val1 = o1.intValue();
		int val2 = o2.intValue();
		return (val1 < val2 ? -1 : (val1 == val2 ? 0 : 1));
	}
	//返回负数表示o1 小于o2，返回0 表示o1和o2相等，返回正数表示o1大于o2
	public int compare(Boolean o1, Boolean o2) {//比较性别(先女后男)
		return (o1.equals(o2) ? 0 : (o1.booleanValue() == false ? -1 : 1));
	}

	@Override
	public int compare(Person o1, Person o2) {
		// TODO Auto-generated method stub
		String firstname1 = o1.getFirstname();
		String firstname2 = o2.getFirstname();
		String lastname1 = o1.getLastname();
		String lastname2 = o2.getLastname();
		Boolean sex1 = o1.getSex();
		Boolean sex2 = o2.getSex();
		Integer age1 = o1.getAge();
		Integer age2 = o2.getAge();

		int compareFirstName = compare(firstname1, firstname2);
		int compareLastName = compare(lastname1, lastname2);
		int compareSex = compare(sex1, sex2);
		if (compareFirstName != 0) {
			return compareFirstName;
		}
		if (compareLastName != 0) {
			return compareLastName;
		}
		if (compareSex != 0) {
			return compareSex;
		}
		return compare(age1, age2);
	}

	public static void main(String[] args) {
		Person[] persons = new Person[] {
				new Person("dndy", "guo", true, 23),
				new Person("cndy", "auo", true, 23),
				new Person("cndy", "buo", true, 23),
				new Person("cndy", "cuo", true, 23),
				new Person("cndy", "duo", true, 23),
				new Person("endy", "duo", true, 23),
				new Person("dndy", "guo", true, 23),
				new Person("bob", "ang", true, 21),
				new Person("bob", "ang", false, 22),
				new Person("bob", "ang", false, 21),
				new Person("bob", "bng", false, 21),
				new Person("bob", "cng", false, 20) };
		for (Person person : persons) {
			System.out.println("before:" + person);
		}
		System.out.println("-------------------------------");
		Arrays.sort(persons, new PersonComparators());
		for (Person person : persons) {
			System.out.println("after:" + person);
		}
	}
}
