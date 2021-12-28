package com.springbackend.Springbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springbackend.Springbackend.model.User;

public interface UserRepository extends JpaRepository<User, String>{
	@Query("SELECT u FROM User u WHERE u.username =?1 and u.password=?2")
			public User validateUser(String username,String password);
	
	
}
