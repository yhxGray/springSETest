package com.zx.other.test;

import java.util.ArrayList;
import java.util.List;

import com.zx.reflect.test.User;

public class DataTypeTest {
	public static void main(String[] args) {
		//stringTest();
		//System.out.println(3.0/0);
		//System.out.println(3%0.0);
		//arrayTest();
		//listTest();
		//objectTest();
		//string2Test();
		string2Test();
		
	}
	
	public static void stringTest(){
		String a="abc";
		String a2="abc";
		String b="a"+"bc"+"";
		String c="a";
		final String c2="c";
		String d=c+"bc";
		String d2=c2+"bc";
		String e=c;
		String e2=c+"";
		System.out.println(a==a2);
		System.out.println(a==b);
		System.out.println(a==d);
		System.out.println(a==d2);
		System.out.println((d==d2)+"  "+d.equals(d2));
		System.out.println((c==e)+"  "+c.equals(e));
		System.out.println((c==e2)+"  "+c.equals(e2));
	}
	
	public static void arrayTest(){
		int[] a=new int[]{1,2,3,4,5};
		int[] b=a;
		a[2]=6;
		System.out.println(b[2]);
	}
	
	public static void listTest(){
		List<String> li=new ArrayList<>();
		li.add("wkk");
		li.add("a123");
		List<String> li2=li;
		li.add("wfdsf");
		System.out.println(li2.get(2));
	}
	
	public static void objectTest(){
		final User u1=new User("11", "sss");
		User u2=u1;
		u1.setAge(23);
		System.out.println(u2.getAge());
		u2.setGrade("123");
		System.out.println(u1.getGrade());
	}
	
	public static void string2Test(){
		String a=new String("wkk");
		String a2="wk";
		String b=a;
		System.out.println(Integer.toHexString(System.identityHashCode(a))+" "+System.identityHashCode(b));
		a=new String("qqq");
		System.out.println(Integer.toHexString(System.identityHashCode(a))+" "+System.identityHashCode(b));
		System.out.println(b);
	}
	
	public static void string3Test(){
		String a=new String("hello");
		String b=new String("hello");
		
		String c="hello";
		System.out.println(a.equals(b));
		System.out.println(a==b);
	}
}
