package com.iitg.ecommerce.Shop.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iitg.ecommerce.Shop.dao.AuthDao;
import com.iitg.ecommerce.Shop.models.User;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	AuthDao authdao; 
	
	@Transactional
	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		User user = authdao.login(username, password); 
		return user; 
	}

}
