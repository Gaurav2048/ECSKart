package com.iitg.ecommerce.Shop.Controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.iitg.ecommerce.Shop.Services.ProductService;
import com.iitg.ecommerce.Shop.models.Busket;
import com.iitg.ecommerce.Shop.models.Cart;
import com.iitg.ecommerce.Shop.models.Categories;
import com.iitg.ecommerce.Shop.models.Home;

@Controller
public class ContentController {

	@Autowired
	ProductService productService; 
	
	@RequestMapping(value = {"/ecskart"}, method = RequestMethod.GET)
	public ModelAndView getLandingPage(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("index"); 
		Home home = productService.getHomePageData(); 
		List<Categories> catList = productService.getCategory(); 
		System.out.print("gsg"+ catList.get(0).getSubcatList().get(0).getSub_cat_name());
		System.out.print(home.getFeaturedItems().size()+" "+catList.size()+" required "+home.getRecommandedList().size());
		modelAndView.addObject("auth", session.getAttribute("auth")); 
		modelAndView.addObject("features", home.getFeaturedItems()); 
		modelAndView.addObject("recommandation", home.getRecommandedList()); 		
		modelAndView.addObject("category", catList); 
		return modelAndView; 
	}
	
	@RequestMapping(value = "/ecskart/contact")
	public ModelAndView getContact() {
		return new ModelAndView("contact-us"); 
	}
	
	@PostMapping(value="/ecskart/cart", produces = "application/json")
	@ResponseBody
	public   ModelAndView showCartPage(@RequestParam String busket ) {
		busket = busket.replaceAll("\\\\", "");
		StringBuilder sb = new StringBuilder(busket); 
		sb.deleteCharAt(0); 
		sb.deleteCharAt(sb.length()-1); 
		System.out.print(sb.toString());
		ModelAndView modelAndView = new ModelAndView("cart"); 
		List<Cart> cartList = new ArrayList<Cart>(); 
			try {
				JSONArray jsonObject = new JSONArray(sb.toString());  
				for(int i =0; i<jsonObject.length(); i++) {
					JSONObject jsonObject2 = (JSONObject) jsonObject.get(i);
					String id = jsonObject2.getString("id"); 
					String name = jsonObject2.getString("name"); 
					int price = jsonObject2.getInt("price");
					int quantity = jsonObject2.getInt("quantity");
					int rate = jsonObject2.getInt("rate"); 
					String image = jsonObject2.getString("image"); 
					Cart cart = new Cart(id, name, price,rate, quantity,  image); 
					cartList.add(cart); 
				}
				
			}catch(Exception e) {
				System.out.print(e.getMessage()); 
			}finally {
				
				if(cartList.size() != 0) {
					modelAndView.addObject("busket", cartList); 
				}
				
			}
		return modelAndView; 
	}
	
	
}
