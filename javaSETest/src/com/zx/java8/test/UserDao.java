package com.zx.java8.test;

import java.util.List;

import com.zx.reflect.test.User;

@FunctionalInterface
public interface UserDao {
	List<User> showUsers();
	default void insertUser(){
		
	}
}
