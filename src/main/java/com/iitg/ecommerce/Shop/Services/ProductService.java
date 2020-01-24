package com.iitg.ecommerce.Shop.Services;

import java.util.List;
import java.util.Locale.Category;

import com.iitg.ecommerce.Shop.models.Categories;
import com.iitg.ecommerce.Shop.models.FloorCategory;
import com.iitg.ecommerce.Shop.models.Home;
import com.iitg.ecommerce.Shop.models.Product;
import com.iitg.ecommerce.Shop.models.SubCategories;

public interface ProductService {
	public Home getHomePageData(); 
	public Product save(Product product); 
	public List<Categories> getCategory();
	public Product getProduct(int product_id); 
	public List<Categories> getCategoryData(); 
	public List<SubCategories> getSubCategories(int cat_id); 
	public void delete(int product_id); 
	public List<Product> getAllProducts(); 
	public List<FloorCategory> getFloorCategories(int sub_Cat_id); 
}
