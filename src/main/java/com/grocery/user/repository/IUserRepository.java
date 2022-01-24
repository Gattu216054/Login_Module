package com.grocery.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grocery.user.entity.User;
@Repository("userRepository")
public interface IUserRepository extends JpaRepository<User,String>{
	
User findByUserName(String userName);
}
