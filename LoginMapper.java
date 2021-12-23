package com.training.springbootnew.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.training.springbootnew.model.Employee;
import com.training.springbootnew.model.Login;


	public class  LoginMapper implements RowMapper<Login> {
		public Login mapRow(ResultSet rs, int rowNum) throws SQLException {
			Login user=new Login();
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
		
			return user;
		}
}
