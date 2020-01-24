package com.iitg.ecommerce.Shop.Controllers;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iitg.ecommerce.Shop.Services.ProductService;
import com.iitg.ecommerce.Shop.dao.ProductDao;
import com.iitg.ecommerce.Shop.models.Product;

/**
 * Handles requests for the application file upload requests
 */
@Controller
public class FileUploadController {
	private static final Logger logger = LoggerFactory
			.getLogger(FileUploadController.class);
	
	@Autowired
	ProductService productService; 

	/**
	 * Upload single file using Spring Controller
	 */
	@RequestMapping(value = "/ecskart/uploadFile", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView uploadFileHandler(@ModelAttribute("product") Product product,
			@RequestParam("file") MultipartFile file,HttpServletRequest request) {
		System.out.println("product_id"+product.getProduct_id()); 
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath =  request.getSession().getServletContext().getRealPath("image/");
			 	String saveDirectory = rootPath+"WEB-INF"+File.separator+"views"+File.separator+"images"+File.separator;
				File dir = new File("src/main/resources/static/ecskart/images/");
				if (!dir.exists())
					dir.mkdirs();
				String fileName = System.currentTimeMillis()+".jpg"; 
				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + fileName);
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				logger.info("Server File Location="
						+ serverFile.getAbsolutePath());
				product.setImage("/images/"+fileName);
				productService.save(product);
				
				ModelAndView modelAndView = new ModelAndView("redirect:/ecskart/add"); 
				return  modelAndView ;
			} catch (Exception e) {
				return new ModelAndView("404"); 
			}
		} else {
			
			productService.save(product);
			ModelAndView modelAndView = new ModelAndView("redirect:/ecskart/add"); 
			return  modelAndView ;
		}
	}
}
