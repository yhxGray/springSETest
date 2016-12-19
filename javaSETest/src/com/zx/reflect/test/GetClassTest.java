package com.zx.reflect.test;

import com.zx.io.test.CopyFile;

public class GetClassTest {
	public static void main(String... args){
		try {
			Class c1=Class.forName("com.zx.io.test.CopyFile");//��һ�ַ�ʽ
			System.out.println(c1.getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Class c2=CopyFile.class;//�ڶ��ַ�ʽ
		Class c3=new CopyFile().getClass();//�����ַ�ʽ
	}
}
