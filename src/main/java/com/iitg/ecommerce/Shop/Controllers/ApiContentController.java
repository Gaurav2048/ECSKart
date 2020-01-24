package com.iitg.ecommerce.Shop.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iitg.ecommerce.Shop.Services.ProductService;
import com.iitg.ecommerce.Shop.models.FloorCategory;
import com.iitg.ecommerce.Shop.models.SubCategories;

@RestController
public class ApiContentController {
	
	@Autowired
	ProductService productService; 

	 @GetMapping("/ecskart/subcat/{cat_id}")
	 public  ResponseEntity getSubCategory(
	            @Valid @PathVariable int cat_id) {
	       	List<SubCategories> subcat = productService.getSubCategories(cat_id);        			
	        return ResponseEntity.ok(subcat);

	    }
	 
	 @GetMapping("/ecskart/floorcat/{floor_id}")
	 public  ResponseEntity getFloorCategory(
	            @Valid @PathVariable int floor_id) {
	       	List<FloorCategory> subcat = productService.getFloorCategories(floor_id);        			
	        return ResponseEntity.ok(subcat);

	    }
	
}
