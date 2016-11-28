package com.test;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		User user=new User();
		user.setId(rs.getInt("Id"));
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setStatus(rs.getInt("status"));
		return user;
	}


}
