package com.iitg.ecommerce.Shop.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iitg.ecommerce.Shop.models.Product;
import com.iitg.ecommerce.Shop.models.User;

@Repository
public class AuthDaoImpl implements AuthDao {

	@Autowired
	EntityManager entityManager; 
	
	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub 
		Session currentSession = entityManager.unwrap(Session.class); 
		Query<User> query = currentSession.createQuery("from User where email=:email and password=:password", User.class); 
		query.setParameter("email", username); 
		query.setParameter("password", password); 
		return query.getSingleResult(); 
	}

}
