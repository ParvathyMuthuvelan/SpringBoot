package com.training.springbootnew.dao;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.training.springbootnew.model.Login;
@Repository
public class UserDaoImpl  extends JdbcDaoSupport implements UserDao{
	@Autowired 
	DataSource dataSource;

	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	@Override
	public boolean validateUser(Login login) {
		boolean result=false;
		try
		{
		String sql = "SELECT * FROM admin WHERE username = ? and password=?";
		Login user= getJdbcTemplate().queryForObject(sql, new Object[] {login.getUsername(),login.getPassword() }, new LoginMapper());
		if(user!=null)
			result=true;
		
		}
		catch(EmptyResultDataAccessException e)
		{
			result=false;
		}
		return result;
	}



}
