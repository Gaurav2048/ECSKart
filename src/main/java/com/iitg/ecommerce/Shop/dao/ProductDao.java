package com.iitg.ecommerce.Shop.dao;

import java.util.List;
import java.util.Locale.Category;

import com.iitg.ecommerce.Shop.models.Categories;
import com.iitg.ecommerce.Shop.models.FloorCategory;
import com.iitg.ecommerce.Shop.models.Product;
import com.iitg.ecommerce.Shop.models.SubCategories;

public interface ProductDao {

	List<Product> getFeaturedItems(); 
	List<Product> getInitialProduct(); 
	List<Product> getRecommandedProducts(); 
	Product getProduct(int product_id); 
	Product addProduct(Product product); 
	List<Categories> getCategories(); 
	void delete(int product_id); 
	List<FloorCategory> getFloorCategories(int sub_category_id); 
	List<SubCategories> getSubcategories(int category_id); 

}
