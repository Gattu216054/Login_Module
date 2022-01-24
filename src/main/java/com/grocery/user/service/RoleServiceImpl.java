package com.grocery.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocery.user.entity.Role;
import com.grocery.user.repository.IRoleRepository;

@Service("roleService")
public class RoleServiceImpl implements IRoleService{

	@Autowired
	private IRoleRepository roleRepository;

	@Override
	public Role createRole(Role role) {
		
		return roleRepository.save(role);
	}
}
