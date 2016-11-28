package com.test;

import java.util.List;

public interface UserDao {
	List<User> show();
	int addUser(User user);
	int deleteUser(int id);
	int update(User user);
}
