package com.springbackend.Springbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbackend.Springbackend.dao.UserRepository;
import com.springbackend.Springbackend.model.User;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public User validateUser(User user) {
		User u=userRepository.validateUser(user.getUsername(),user.getPassword());
		
		return u;
	}
	
}
