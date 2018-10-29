package com.nana.bankapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/new")
	public String newAccount(Model model) {
		return "register";
	}

	@RequestMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {

		if (error != null) {
			System.out.println("invalid pak eko.");
			model.addAttribute("error", "Invalid username or password");
		}

		if (logout != null) {
			System.out.println("logout in");
			model.addAttribute("msg", "you've been logged out succesfully");
		}

		return "login";
	}
}
