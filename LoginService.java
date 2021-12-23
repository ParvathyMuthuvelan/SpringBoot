package com.training.springbootnew.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.springbootnew.dao.UserDao;
import com.training.springbootnew.model.Login;

@Service
public class LoginService {
	@Autowired
	UserDao userDao;
	public boolean validate(Login login)	{
		
		//return (bean.getUsername().equals("admin") && bean.getPassword().equals("admin@123"));
		boolean result=userDao.validateUser(login);
		return result;
	}
	

}
