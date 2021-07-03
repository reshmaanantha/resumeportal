package com.computergurukul.resumeportal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "Hello";
	}
	@GetMapping("/edit")
	public String edit() {
		return "edit pg";
	}
	
	@GetMapping("/view/{userId}")
	public String view(@PathVariable String userId,Model theModel) {
		theModel.addAttribute("userId",userId);
		if(userId.equals("1"))
		return "profile-templates/1/index";
		if(userId.equals("2"))
			return "profile-templates/2/index";
		if(userId.equals("3"))
			return "profile-templates/3/index";
	return null;	
	}
}
