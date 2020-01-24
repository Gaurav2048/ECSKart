package com.iitg.ecommerce.Shop.Services;

import java.util.List;
import java.util.Locale.Category;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.iitg.ecommerce.Shop.dao.ProductDao;
import com.iitg.ecommerce.Shop.models.Categories;
import com.iitg.ecommerce.Shop.models.FloorCategory;
import com.iitg.ecommerce.Shop.models.Home;
import com.iitg.ecommerce.Shop.models.Product;
import com.iitg.ecommerce.Shop.models.SubCategories;


@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
    ProductDao productDao; 
	
	
	@Transactional
	@Override
	public Home getHomePageData() {
		// TODO Auto-generated method stub
	 	List <Product> list_one =  productDao.getInitialProduct(); 
	 	List <Product> list_two =  productDao.getFeaturedItems(); 
	 	return new Home(list_two, list_one);	
	}


	@Transactional
	@Override
	public Product save(Product product) {
		// TODO Auto-generated method stub
		Product loaded_p = productDao.getProduct(product.getProduct_id()); 
		if(loaded_p==null)
		{
			return productDao.addProduct(product);
		}else {
			loaded_p.setProduct_name(product.getProduct_name());
			loaded_p.setDescription(product.getDescription());
			loaded_p.setPrice(product.getPrice());
			loaded_p.setDiscount(product.getDiscount());
			loaded_p.setOnsale(product.getOnsale());
			loaded_p.setCat_id(product.getCat_id());
			loaded_p.setSub_cat_id(product.getSub_cat_id());
			loaded_p.setFloor_cat_id(product.getFloor_cat_id());
			loaded_p.setImage(product.getImage());			
			return loaded_p; 
		}
	}

	@Transactional
	@Override
	public List<Categories> getCategory() {
		// TODO Auto-generated method stub
		List<Categories> categories =  productDao.getCategories(); 
		for(int i =0; i<categories.size(); i++) {
			List<SubCategories> scatList = productDao.getSubcategories(categories.get(i).getCategory_id()); 
			for(int j =0; j<scatList.size(); j++) {
				List<FloorCategory> fList = productDao.getFloorCategories(scatList.get(j).getSub_cat_id()); 
				scatList.get(j).setfList(fList);
			}
			categories.get(i).setSubcatList(scatList);
		}
		return categories;
	}

	@Transactional
	@Override
	public List<Categories> getCategoryData() {
		// TODO Auto-generated method stub
		List<Categories> categories =  productDao.getCategories(); 
		return categories;
	}

	@Transactional
	@Override
	public List<SubCategories> getSubCategories(int cat_id) {
		List<SubCategories> scatList = productDao.getSubcategories(cat_id); 
		return scatList;
	}

	@Transactional
	@Override
	public List<FloorCategory> getFloorCategories(int sub_Cat_id) {
		// TODO Auto-generated method stub
		List<FloorCategory> floorcatList = productDao.getFloorCategories(sub_Cat_id); 
		return floorcatList;
	}

	@Transactional
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		List<Product> pList = productDao.getFeaturedItems();
		return pList;
	}

	@Transactional
	@Override
	public Product getProduct(int product_id) {
		// TODO Auto-generated method stub
		Product product = productDao.getProduct(product_id); 
		return product;
	}

	@Transactional
	@Override
	public void delete(int product_id) {
		// TODO Auto-generated method stub
		productDao.delete(product_id);
		
	}

}
