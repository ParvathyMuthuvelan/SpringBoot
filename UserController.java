package com.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.User;

@Controller
public class UserController {
	@RequestMapping(value = "/showUser", method = RequestMethod.GET)
	public String showForm(User user) {
		return "userForm";
	}

	@RequestMapping(value = "/submitUser", method = RequestMethod.POST)
	public String checkUserInfo(@Valid User user, BindingResult bindingResult) {
		String result = "";
		if (bindingResult.hasErrors()) {
			result = "userForm";
		} else {
			result = "success";
		}
		return result;
	}
}