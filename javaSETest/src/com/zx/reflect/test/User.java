package com.zx.reflect.test;

import java.io.Serializable;

public class User implements Comparable<User>{
	private String name;
	String password;
	protected int age;
	public String grade;
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public void test1(){
		System.out.println("www");
	}
	
	public int test2(String name){
		System.out.println(name);
		return 2;
	}
	
	public String test3(String name,int age){
		System.out.println(name+age);
		return "wkk";
	}
	
	
	User(){}
	
	public User(String name) {
		super();
		this.name = name;
	}
	
	public User(String name, String password) {
		this(name);
		this.password = password;
	}
	public User(String name, String password, int age, String grade) {
		this(name,password);
		this.age = age;
		this.grade = grade;
	}
	
	public int compareTo(User u){
		return this.getName().compareTo(u.getName());
	}
	
	
}
