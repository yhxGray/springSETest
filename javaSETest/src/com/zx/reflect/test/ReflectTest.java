package com.zx.reflect.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectTest {
	
	public static void getFieldsTest(){
		Class c=User.class;
		try {
			Field[] fs=c.getFields();//���public���ε�����
			for (Field field : fs) {
				System.out.print(field.getName()+" ");
			}
			System.out.println();
			Field[] fds=c.getDeclaredFields();//������з���Ȩ�޵�����
			for (Field field : fds) {
				System.out.print(field.getName()+" ");
			}
			System.out.println();
			Field fm=c.getDeclaredField("name");//�����������Ϊname������
			Field fp=c.getDeclaredField("password");
			fm.setAccessible(true);//�ƻ���װ���Ӷ������private�����Խ���set����
			Object o=c.newInstance();//����һ������
			fm.set(o, "wkk");
			fp.set(o, "a123");//����password����private�ģ����Կ���ֱ��set
			System.out.println(fm.get(o)+"  "+fp.get(o));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void getConstructorTest(){
		Class c=User.class;//�˴�c���Լӷ���<User>
		try {
			Constructor[] cs=c.getConstructors();//ֻ�ܻ�ȡpublic�Ĺ����������������Declared
			Constructor[] cds=c.getDeclaredConstructors();
			System.out.println();
			Constructor c1=c.getDeclaredConstructor(String.class);
			Constructor c2=c.getDeclaredConstructor();
			Constructor<User> c3=c.getDeclaredConstructor(String.class,String.class);
			c1.setAccessible(true);//����c1��������дʱ��private�ģ�������Ҫ���Ʒ�װ
			User u1=(User)c1.newInstance("wkk");
			User u2=(User)c2.newInstance();
			User u3=c3.newInstance("wkk","a123");//����c3���˷��ͣ���������ǿת
			System.out.println(u1.getName());
			System.out.println(u2.getName());
			System.out.println(u3.getName()+" "+u3.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void getMethodTest(){
		Class<User> c=User.class;
		try {
			Method[] ms=c.getMethods();
			Method[] mds=c.getDeclaredMethods();
			User u=c.newInstance();//����c���˷������Բ���ǿת
			Method m1=c.getDeclaredMethod("test1");//��һ�������Ƿ�����������ĸ��ݷ�����Ҫ��д���������Class
			Method m2=c.getMethod("test2", String.class);
			Method m3=c.getDeclaredMethod("test3", String.class,int.class);
			m1.invoke(u);//ִ�з�����invoke,������һ�������Ƕ��󣬺����Ƿ�����Ҫ�ľ������
			m2.invoke(u,"wkk");
			m3.invoke(u,"wkk",12);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//getFieldsTest();
		//getConstructorTest();
		getMethodTest();
	}
}
