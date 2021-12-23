package com.training.springbootnew.service;

import org.springframework.stereotype.Service;

import com.training.springbootnew.model.Login;

@Service
public class LoginService {
	
	public boolean validate(Login bean)	{
		
		return (bean.getUsername().equals("admin") && bean.getPassword().equals("admin@123"));
	}
	

}
