package com.zx.other.test;

import java.io.IOException;
import java.util.Calendar;

public class SystemTest {
	public static void main(String[] args) {
		//runtimeTest();
		calendarTest();
	}
	
	public static void runtimeTest(){
		Runtime rt=Runtime.getRuntime();
		System.out.println(rt.freeMemory()/(1024*1024));
		System.out.println(rt.maxMemory()/1024/1024);
		try {
			rt.exec("mspaint.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 该方法针对Calendar的set方法进行测试，证明是延迟修改
	 */
	public static void calendarTest(){
		Calendar cl=Calendar.getInstance();
		cl.set(2002, 7, 31);
		cl.set(Calendar.MONTH, 8);//此时仅是将cl的月份改成了9，但是并没有计算真正时间
		//System.out.println(cl.getTime());不注释掉则会计算真正时间，9月31自动变成10月1
		cl.set(Calendar.DATE,6);//此时仅是将cl的日期改成了5，也没有计算真正时间
		System.out.println(cl.getTime());//由于调用了get，所以计算真正时间后打印
	}
}
