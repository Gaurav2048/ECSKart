package com.iitg.ecommerce.Shop.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	int user_id; 
	@Column
	String user_name;
	@Column
	String name;
	@Column
	String email;
	@Column
	String phone_number;
	@Column
	String password; 
	@Column
	int role; 
	@Column
	int email_verified;
	@Column
	int phone_verified;
	
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", name=" + name + ", email=" + email
				+ ", phone_number=" + phone_number + ", email_verified=" + email_verified + ", phone_verified="
				+ phone_verified + "]";
	}

	
	
	public int getRole() {
		return role;
	}



	public void setRole(int role) {
		this.role = role;
	}



	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public int getEmail_verified() {
		return email_verified;
	}
	public void setEmail_verified(int email_verified) {
		this.email_verified = email_verified;
	}
	public int getPhone_verified() {
		return phone_verified;
	}
	public void setPhone_verified(int phone_verified) {
		this.phone_verified = phone_verified;
	} 	
}
