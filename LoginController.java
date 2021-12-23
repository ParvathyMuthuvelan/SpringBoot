package com.training.springbootnew.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.training.springbootnew.model.Login;
import com.training.springbootnew.service.LoginService;




@Controller
//@SessionAttributes("login")
public class LoginController {
	
/*	@ModelAttribute("login")
	public LoginloginBean()
	{
	    return new LoginBean();
	}*/
	
	@Autowired
	private LoginService service;

    @RequestMapping(value="/showLogin", method=RequestMethod.GET)
	public String showLoginpage(@ModelAttribute("login") Login log) {
	    
			return "login"; //viewname

	}


	@RequestMapping(value="/loginValidate", method=RequestMethod.POST)
	public String checkLoginDetails(ModelMap map,@ModelAttribute("login") Login log, 
			RedirectAttributes attributes) {
		
	    if(service.validate(log))
	    {
	    	
	    	map.addAttribute("uname", log.getUsername());
	        return "welcome";
	    	
	    }
	    else
	    {
	       // return "invalid";
	    	attributes.addFlashAttribute("message", "Invalid credentials..!Try again");
	    	return "redirect:showLogin"; //call the requestmapping showLogin
	    }

	}
	

}
