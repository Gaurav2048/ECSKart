package com.iitg.ecommerce.Shop.Services;

import com.iitg.ecommerce.Shop.models.User;

public interface AuthService {
	
	User login(String username, String password); 
	
}
