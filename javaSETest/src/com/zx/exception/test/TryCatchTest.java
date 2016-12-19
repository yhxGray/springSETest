package com.zx.exception.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TryCatchTest {
	String a=null;
	@Test
	public void catchTest(){
		try{
			aa();
			System.out.println("continue");
		}catch(Exception e){
			System.out.println("wwww");
		}
	}
	
	public void aa(){
		try{
			boolean b=a.equals("bb");
			System.out.println(b);
		}catch(Exception e){
			System.out.println("kk");
			throw e;
		}
	}
	
	@Test
	public void testxx(){
		double a=3.0;
		double b=3.0;
		if(a==b){
			System.out.println("ok");
		}
		float c=3.1f;
		if(c==3.1){
			System.out.println("ok2");
		}
	}
	
	@Test
	public void testyy(){
		double l_value=12.11;
		String aa=String.format("%."+ 0 +"f%%", l_value * 100);
		String bb=String.format("wfdfgeasdfds",aa);
		System.out.println(aa);
		System.out.println(bb);
	}
	@Test
	public void testzz(){
		List<String> l=new ArrayList<>();
		l.add("ww");
		l.add("ee");
		l.add("wwe");
		l.add("a");
		l.add("b");
		testtt(l);
	}
	public void testtt(List<String> li){
		int i=0;
		while(i<5){
			if(li.get(i).contains("s")){
				System.out.println(li);
			}
			i++;
		}
	}

}
