package com.grocery.user.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.user.entity.User;
import com.grocery.user.service.UserServiceImpl;

@RestController
public class UserController {

	@Autowired
	private UserServiceImpl userService;



	@PostConstruct public void initRoleAndUser() 
	{ 
		userService.initRoleAndUser();
	}

	@PostMapping(value="/registerUser",produces="application/json")
	public String registerUser(@RequestBody User user)
	{
		return userService.registerUser(user);
	}
	
	 @GetMapping(value="/forAdmin")
	    @PreAuthorize("hasRole('ROLE_ADMIN')")
	    public String forAdmin(){
	        return "This URL is only accessible to the admin";
	    }

	    @GetMapping(value="/forUser")
	    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
	    public String forUser(){
	        return "This URL is only accessible to the user";
	    }
	    @GetMapping(value="/admin/{userName}")
	    public User getUser(@PathVariable String userName)
	    {
	    return userService.getUser(userName);	
	    }
}
