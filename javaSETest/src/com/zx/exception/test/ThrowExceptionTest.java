package com.zx.exception.test;

import org.junit.Test;

public class ThrowExceptionTest {
	/**
	 * 当抛出一个异常时，方法中异常代码的下方代码将不会执行，直到某个方法进行了try catch，
	 * 如果一直没有try catch，则会传给JVM，终止程序运行
	 */
	@Test
	public void ThrowRuntimeExceptionTest(){
		String a_B_c="";
		System.out.println(a_B_c);
		try{
			testbb();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("kkkk");
		}
		System.out.println("continue");
	}
	
	@Test
	public void testbb(){
		Testaa();
		System.out.println("ssss");
	}
	
	@Test
	public void Testaa(){
		String a=null;
		if(a==null) raise();
		String b="wkk";
		System.out.println(b);
	}
	
	public void raise(){
		throw new RuntimeException();
	}
}
