package com.grocery.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.user.entity.Role;
import com.grocery.user.service.RoleServiceImpl;

@RestController
public class RoleController {

	@Autowired
	private RoleServiceImpl roleService;
	
	@PostMapping(value="/createRole",produces="application/json")
	public Role createRole(@RequestBody Role role)
	{
		return roleService.createRole(role);
	}
}
