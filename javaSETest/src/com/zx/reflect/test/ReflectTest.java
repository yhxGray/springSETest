package com.zx.reflect.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectTest {
	
	public static void getFieldsTest(){
		Class c=User.class;
		try {
			Field[] fs=c.getFields();//获得public修饰的属性
			for (Field field : fs) {
				System.out.print(field.getName()+" ");
			}
			System.out.println();
			Field[] fds=c.getDeclaredFields();//获得所有访问权限的属性
			for (Field field : fds) {
				System.out.print(field.getName()+" ");
			}
			System.out.println();
			Field fm=c.getDeclaredField("name");//获得属性名称为name的属性
			Field fp=c.getDeclaredField("password");
			fm.setAccessible(true);//破坏封装，从而允许对private的属性进行set操作
			Object o=c.newInstance();//创建一个对象
			fm.set(o, "wkk");
			fp.set(o, "a123");//由于password不是private的，所以可以直接set
			System.out.println(fm.get(o)+"  "+fp.get(o));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void getConstructorTest(){
		Class c=User.class;//此处c可以加泛型<User>
		try {
			Constructor[] cs=c.getConstructors();//只能获取public的构造器，获得所有用Declared
			Constructor[] cds=c.getDeclaredConstructors();
			System.out.println();
			Constructor c1=c.getDeclaredConstructor(String.class);
			Constructor c2=c.getDeclaredConstructor();
			Constructor<User> c3=c.getDeclaredConstructor(String.class,String.class);
			c1.setAccessible(true);//由于c1构造器编写时是private的，所以需要打破封装
			User u1=(User)c1.newInstance("wkk");
			User u2=(User)c2.newInstance();
			User u3=c3.newInstance("wkk","a123");//由于c3加了泛型，所以无需强转
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
			User u=c.newInstance();//由于c加了泛型所以不用强转
			Method m1=c.getDeclaredMethod("test1");//第一个参数是方法名，后面的根据方法需要填写具体参数的Class
			Method m2=c.getMethod("test2", String.class);
			Method m3=c.getDeclaredMethod("test3", String.class,int.class);
			m1.invoke(u);//执行方法是invoke,方法第一个参数是对象，后面是方法需要的具体参数
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
