package com.computergurukul.resumeportal;

import java.security.Principal;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.computergurukul.resumeportal.models.Education;
import com.computergurukul.resumeportal.models.Job;
import com.computergurukul.resumeportal.models.UserProfile;

@Controller
public class HomeController {
	
	@Autowired
	UserProfileRepository userProfileRepository;
	@GetMapping("/")
	public String home() {
		return "index";
	}
	@GetMapping("/edit")
	public String edit(Model theModel, Principal principal ,@RequestParam (required=false)String add) {
		String userId=principal.getName();
		Optional<UserProfile> userProfileOptional=userProfileRepository.findByUserName(userId);
		userProfileOptional.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userId));
		UserProfile userProfile=userProfileOptional.get();
		
		if("job".equals(add)) {
			userProfile.getJobs().add(new Job());
		}
		else if("education".equals(add)) {
			userProfile.getEducations().add(new Education());
		}
		else if("skills".equals(add)) {
			userProfile.getSkills().add(new String());
		}
			
			
				
		theModel.addAttribute("userId",principal.getName());
		theModel.addAttribute("userProfile",userProfile);
		return "profile-edit";
	}
	@GetMapping("/delete")
	public String delete(Model theModel, Principal principal ,@RequestParam String type,@RequestParam int index) {
	
		String userName=principal.getName();
		Optional<UserProfile> userProfileOptional=userProfileRepository.findByUserName(userName);
		userProfileOptional.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));
		UserProfile userProfile=userProfileOptional.get();
		if("job".equals(type)) {
			userProfile.getJobs().remove(index);
		}
		else if("education".equals(type)) {
			userProfile.getEducations().remove(index);
		}
		else if("skills".equals(type)) {
			userProfile.getSkills().remove(index);
		}
		userProfileRepository.save(userProfile);
		return "redirect:/edit";
	}
	
	
	@PostMapping("/edit")
	public String postEdit(Model theModel, Principal principal,@ModelAttribute UserProfile userProfile) {
		String userName=principal.getName();
		Optional<UserProfile> userProfileOptional=userProfileRepository.findByUserName(userName);
		userProfileOptional.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));
		UserProfile saveduserProfile=userProfileOptional.get();
		userProfile.setId(saveduserProfile.getId());
		userProfile.setUserName(userName);
		userProfileRepository.save(userProfile);
		return "redirect:/view/" + userName;
	}
	@GetMapping("/view/{userId}")
	public String view(Principal principal,@PathVariable String userId,Model theModel) {
		if(principal!=null&&principal.getName()!="")
		{
		boolean currentUserProfile=principal.getName().equals(userId);
		theModel.addAttribute("currentUserProfile",currentUserProfile);
		}
		Optional<UserProfile> userProfileOptional=userProfileRepository.findByUserName(userId);
		userProfileOptional.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userId));
		UserProfile userProfile=userProfileOptional.get();
		theModel.addAttribute("userId",userId);
		theModel.addAttribute("userProfile",userProfile);
	
			return "profile-templates/"+ userProfile.getTheme()+"/index";

	}
}
