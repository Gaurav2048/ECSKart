package com.iitg.ecommerce.Shop.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iitg.ecommerce.Shop.models.Categories;
import com.iitg.ecommerce.Shop.models.FloorCategory;
import com.iitg.ecommerce.Shop.models.Product;
import com.iitg.ecommerce.Shop.models.SubCategories;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private EntityManager entityManager; 
	
	@Override
	public List<Product> getFeaturedItems() {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class); 
		Query<Product> query =  currentSession.createQuery("from Product order by product_id desc", Product.class); 
		return query.getResultList(); 
	}

	@Override
	public List<Product> getInitialProduct() {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class); 
		Query<Product> query =  currentSession.createQuery("from Product", Product.class).setMaxResults(3); 
		return query.getResultList(); 
	}

	@Override
	public List<Product> getRecommandedProducts() {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public List<Categories> getCategories() {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class); 
		Query<Categories> query =  currentSession.createQuery("from Categories", Categories.class); 
		return query.getResultList(); 
	
	}

	@Override
	public List<SubCategories> getSubcategories(int category_id) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class); 
		Query<SubCategories> query =  currentSession.createQuery("from SubCategories where category_id=:category_data", SubCategories.class); 
		query.setParameter("category_data", category_id); 
		return query.getResultList(); 
	}

	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class); 
		 session.save(product); 
		 
		 return product;
	}

	@Override
	public List<FloorCategory> getFloorCategories(int sub_category_id) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class); 
		Query<FloorCategory> query =  currentSession.createQuery("from FloorCategory where sub_category_id = :floor_cat_id", FloorCategory.class); 
		query.setParameter("floor_cat_id", sub_category_id); 
		return query.getResultList(); 
	}

	@Override
	public Product getProduct(int product_id) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class); 
		Query<Product> product = session.createQuery("from Product where product_id = :p_id", Product.class); 
		product.setParameter("p_id", product_id); 
		return product.getSingleResult();
	}

	@Override
	public void delete(int product_id) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class); 
		Product product = session.get(Product.class, product_id);
		System.out.print(product.getProduct_name());
		session.delete(product);
		
	}


}
