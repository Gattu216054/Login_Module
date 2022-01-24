package com.grocery.user.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.grocery.user.entity.Role;
import com.grocery.user.entity.User;
import com.grocery.user.repository.IRoleRepository;
import com.grocery.user.repository.IUserRepository;
@Service("userService")
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private IRoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public String registerUser(User user) {
	String role = "ROLE_CUSTOMER" ;
	user.setPassword(passwordEncoder.encode(user.getPassword()));
	user.setRole(role);
	userRepository.save(user);
	return "User successfully registered with the role = " + user.getRole();
	}

	 public void initRoleAndUser() {

	        Role adminRole = new Role();
	        adminRole.setRoleName("Admin");
	        adminRole.setRoleDescription("Admin role");
	       roleRepository.save(adminRole);

	        Role userRole = new Role();
	        userRole.setRoleName("User");
	        userRole.setRoleDescription("Default role for newly created record");
	         roleRepository.save(userRole);

	        User adminUser = new User();
	       
	        adminUser.setUserName("admin123");
	        adminUser.setPassword(getEncodedPassword("Admin@123"));
	        adminUser.setFirstName("admin");
	        adminUser.setLastName("admin");
	        adminUser.setAddress("xy block");
	        adminUser.setEmail("admin@gmail.com");
	        adminUser.setPhoneNumber("9014918216");
	        Set<Role> adminRoles = new HashSet<>();
	        adminRoles.add(adminRole);
	        adminUser.setRole("ROLE_ADMIN");
	        userRepository.save(adminUser);
	 }
	 
	 @Override
	public String getEncodedPassword(String password)
	{
		return passwordEncoder.encode(password);
	}

	public User getUser(String userName) {
		
		return userRepository.findByUserName(userName);
	}
	 
	 

}
