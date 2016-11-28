package com.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoImplTest{
	public static void main(String[] args) {
		 ApplicationContext context =new ClassPathXmlApplicationContext("applicationContext.xml");  
	        UserDaoImpl userDaoImpl = (UserDaoImpl)context.getBean("userDao"); 
	        
	        User uu=new User("abcde", "www", 1);
//	        userDaoImpl.addUser(uu);
	        
	        userDaoImpl.deleteUser(19);
	        
	        
//	        List<User> ulist=userDaoImpl.show();
//	        for (User user : ulist) {
//				System.out.println(user);
//			}
	}
}
