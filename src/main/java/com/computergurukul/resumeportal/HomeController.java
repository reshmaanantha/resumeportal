package com.computergurukul.resumeportal;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.computergurukul.resumeportal.models.UserProfile;

@Controller
public class HomeController {
	
	@Autowired
	UserProfileRepository userProfileRepository;
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
		
		Optional<UserProfile> userProfileOptional=userProfileRepository.findByUserName(userId);
		userProfileOptional.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userId));
		UserProfile userProfile=userProfileOptional.get();
		theModel.addAttribute("userId",userId);
		theModel.addAttribute("userProfile",userProfile);
		
			return "profile-templates/"+ userProfile.getTheme()+"/index";

	}
}
