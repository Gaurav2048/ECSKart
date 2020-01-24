package com.iitg.ecommerce.Shop.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iitg.ecommerce.Shop.Services.AuthService;
import com.iitg.ecommerce.Shop.models.User;

@Controller
public class AuthController {

	@Autowired
	AuthService authService; 
	
	@RequestMapping(value = {"/ecskart/login"}, method = RequestMethod.GET)
	public ModelAndView login(HttpSession session) {
		if(session.getAttribute("auth") != null) {
			if(session.getAttribute("role").equals(0)) {
				ModelAndView modelAndView = new ModelAndView("redirect:/ecskart/add"); 
				return modelAndView; 
			}else {
				ModelAndView modelAndView = new ModelAndView("redirect:/ecskart/"); 
				return modelAndView; 
		}
	}
		ModelAndView modelAndView = new ModelAndView("login"); 
		modelAndView.addObject("user", new User());
		return modelAndView; 
	}

	
	
	@RequestMapping(value = {"/ecskart/login"}, method = RequestMethod.POST)
	public ModelAndView authenticate(@ModelAttribute User user, HttpSession session) {
		System.out.print("data "+user.getEmail());
		User return_user = authService.login(user.getEmail(), user.getPassword()); 
	
		if(return_user!=null) {
			session.setAttribute("auth", true);
			session.setAttribute("role", return_user.getRole());
			if(return_user.getRole()==1) {
				ModelAndView modelAndView = new ModelAndView("redirect:/ecskart/add"); 
				return modelAndView; 
			}else {
				ModelAndView modelAndView = new ModelAndView("redirect:/ecskart/"); 
				return modelAndView; 
			}
		}else {
			ModelAndView modelAndView = new ModelAndView("redirect:/login");
			modelAndView.addObject("error", "no user found"); 
			return modelAndView; 
		}

	}
	
	@RequestMapping(value="/ecskart/logout")
	public ModelAndView logout(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("redirect:/ecskart"); 
		session.removeAttribute("auth");
		session.removeAttribute("role");
		return modelAndView; 
	}
	
		
	
}
