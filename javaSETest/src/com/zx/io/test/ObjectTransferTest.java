package com.zx.io.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.junit.Test;

import com.zx.reflect.test.User;

public class ObjectTransferTest {
	@Test
	public void writeTest(){
		UserSer us=new UserSer();
		us.setId(12);
		us.setName("wet");
		us.setUser(new User("wdd"));
		writeObject(us);
	}
	
	public void writeObject(Object obj){
		try {
			ObjectOutputStream oo=new ObjectOutputStream(new FileOutputStream(new File("E://test//objectTest.txt")));
			oo.writeObject(obj);
			oo.close();
		}  catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readFileToObj(String path){
		try {
			ObjectInputStream oi=new ObjectInputStream(new FileInputStream(new File(path)));
			try {
				Object obj=oi.readObject();
				if(obj instanceof UserSer){
					System.out.println(obj);
					System.out.println(((UserSer)obj).getUser().getName());
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			oi.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void readTest(){
		String path="E:/test/objectTest.txt";
		readFileToObj(path);
	}
	
}

class UserSer implements Serializable{
	private int id;
	private String name;
	private User user;
	public UserSer(int id, String name, User user) {
		super();
		this.id = id;
		this.user = user;
		this.name = name;
	}
	public UserSer() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "UserSer [id=" + id + ", name=" + name + ", user=" + user + "]";
	}
	
	
}
