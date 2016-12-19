package com.zx.exception.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.zx.reflect.test.User;

public class ListOOMTest {
	@Test
	public void arrayListSizeTest(){
		List<User> li=new ArrayList<>();
		for (int i = 0; i < 200000000; i++) {
			try {
				li.add(new User("kk"));
			} catch (OutOfMemoryError e) {
				System.out.println("xxxxxxxxxxxx:  "+i);
				e.printStackTrace();
				break;
			}
		}
		
	}
}
