package com.training.springbootnew.dao;

import com.training.springbootnew.model.Login;

public interface UserDao {
public boolean validateUser(Login login);
}
