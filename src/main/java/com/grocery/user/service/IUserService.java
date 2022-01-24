package com.grocery.user.service;

import com.grocery.user.entity.User;

public interface IUserService {
	
public String registerUser(User user);
public void initRoleAndUser();
public String getEncodedPassword(String password);
public User getUser(String userName);
}
