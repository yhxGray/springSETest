package com.zx.java8.test;

import java.util.List;

public interface Dao<T>{
	default List<T> showAll(){
		return null;
	}
}
