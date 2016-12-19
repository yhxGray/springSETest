package com.zx.other.test;

public class MemoryTest {
	private static void swap(UU uu) {
		String temp="";
		temp=uu.a;
		uu.a=uu.b;
		uu.b=temp;
	}
	
	private static void swap(String a,String b){
		String temp="";
		temp=a;
		a=b;
		b=temp;
	}
	public static void main(String[] args) {
		UU uu=new UU();
		uu.a="ww";
		uu.b="www";
		swap(uu);
		System.out.println(uu.a+" "+uu.b);
		String a=new String("kk");String b=new String("kkk");
		swap(a,b);
		System.out.println(a+" "+b);
	}
}

class UU{
	public String a;
	String b;
}
