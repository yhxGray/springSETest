package com.test;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl extends JdbcTemplate implements UserDao{
	
	@Override
	public List<User> show() {
		List<User> ulist=query("select * from t_user", new UserMapper());
		return ulist;
	}

	@Override
	public int addUser(User user) {
		String sql="insert into t_user(username,password,status) values(?,?,?)";
		return update(sql,user.getUsername(),user.getPassword(),user.getStatus());
	}

	@Override
	public int deleteUser(int id) {
		String sql="delete from t_user where id=?";
		return update(sql,id);
	}

	@Override
	public int update(User user) {
		String sql="update t_user set username=?,password=?,status=? where id=?";
		return update(sql,user.getUsername(),user.getPassword(),user.getStatus(),user.getId());
	}
	
	
	
}
