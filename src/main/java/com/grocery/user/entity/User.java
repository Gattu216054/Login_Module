package com.grocery.user.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="UserService")
public class User {
	
	@Id
	@NotBlank(message="userName should not be blank")
	private String userName;
	@NotBlank(message="firstName should not be blank")
	@Size(min=3,message="firstName should have minimum 3 characters")
	private String firstName;
	@NotBlank(message="lastName should not be blank")
	@Size(min=3,message="lastName should be atleast 3 characters")
	private String lastName;	
	@Email(message="invalid email")
	private String email;
	@NotBlank(message="Give correct phoneNumber")
	private String phoneNumber;
	private String address;
	@NotBlank(message="password should not be blank")
	@Size(min=5,message="Your password must have at least 5 characters")
	private String password;
	/*
	 * @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	 * 
	 * @JoinTable(name = "USER_ROLE", joinColumns = {
	 * 
	 * @JoinColumn(name = "USER_ID") }, inverseJoinColumns = {
	 * 
	 * @JoinColumn(name = "ROLE_ID") } )
	 */
	private String role;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
