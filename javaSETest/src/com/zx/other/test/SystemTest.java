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
	 * �÷������Calendar��set�������в��ԣ�֤�����ӳ��޸�
	 */
	public static void calendarTest(){
		Calendar cl=Calendar.getInstance();
		cl.set(2002, 7, 31);
		cl.set(Calendar.MONTH, 8);//��ʱ���ǽ�cl���·ݸĳ���9�����ǲ�û�м�������ʱ��
		//System.out.println(cl.getTime());��ע�͵�����������ʱ�䣬9��31�Զ����10��1
		cl.set(Calendar.DATE,6);//��ʱ���ǽ�cl�����ڸĳ���5��Ҳû�м�������ʱ��
		System.out.println(cl.getTime());//���ڵ�����get�����Լ�������ʱ����ӡ
	}
}
