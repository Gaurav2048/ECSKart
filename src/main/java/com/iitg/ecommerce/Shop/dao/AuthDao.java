package com.iitg.ecommerce.Shop.dao;

import com.iitg.ecommerce.Shop.models.User;

public interface AuthDao {
	User login(String username, String password); 
}
