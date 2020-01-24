package com.iitg.ecommerce.Shop.Controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.iitg.ecommerce.Shop.Services.ProductService;
import com.iitg.ecommerce.Shop.models.Categories;
import com.iitg.ecommerce.Shop.models.Product;
import com.iitg.ecommerce.Shop.models.SubCategories;

@Controller
public class AdminController {
	
	@Autowired
	ProductService ProductService; 
	
	@RequestMapping(value = {"/ecskart/add"}, method = RequestMethod.GET)
	public ModelAndView addProduct(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("addproduct"); 
	 	List<Categories> list =   ProductService.getCategoryData(); 
		modelAndView.addObject("product", new Product()); 
		System.out.print("role"+session.getAttribute("role"));
		modelAndView.addObject("role", session.getAttribute("role") );  
		modelAndView.addObject("categories", list); 
		return modelAndView; 				
	}
	
	@RequestMapping(value = "/ecskart/products" ,  method=RequestMethod.GET )
	public ModelAndView getProducts(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("products"); 
		modelAndView.addObject("role", session.getAttribute("role") ); 
		modelAndView.addObject("products", ProductService.getAllProducts());
		return modelAndView; 
	}
	
	
	@RequestMapping(value = "/ecskart/product/{product_id}" ,  method=RequestMethod.GET )
	public ModelAndView getProducts(@PathVariable int product_id, HttpSession session ) {
		ModelAndView modelAndView = new ModelAndView("addproduct"); 
		modelAndView.addObject("role", session.getAttribute("role") ); 
		List<Categories> list =   ProductService.getCategoryData(); 
		modelAndView.addObject("categories", list); 
		modelAndView.addObject("product", ProductService.getProduct(product_id));
		return modelAndView; 
	}
	
	@RequestMapping(value = "/ecskart/delete/{product_id}")
	public ModelAndView degelte(@PathVariable int product_id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/ecskart/products");
		ProductService.delete(product_id);
		return modelAndView; 
	}
	
	
	
	@RequestMapping(value = {"/ecskart/add_item"}, method = RequestMethod.POST)
	public ModelAndView addProduct(@ModelAttribute("product") Product product, HttpSession session ) {
		ModelAndView modelAndView = new ModelAndView("redirect:/ecskart/add"); 
		System.out.print(product.getDescription());
		return modelAndView; 
	}
	
	
}
