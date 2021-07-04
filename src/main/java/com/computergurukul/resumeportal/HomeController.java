package com.computergurukul.resumeportal;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.computergurukul.resumeportal.models.Education;
import com.computergurukul.resumeportal.models.Job;
import com.computergurukul.resumeportal.models.UserProfile;

@Controller
public class HomeController {
	
	@Autowired
	UserProfileRepository userProfileRepository;
	@GetMapping("/")
	public String home() {
		 Optional<UserProfile> profileOptional = userProfileRepository.findByUserName("reshma");
	        profileOptional.orElseThrow(() -> new RuntimeException("Not found "));

	        UserProfile profile1 = profileOptional.get();
        Job job1 = new Job();
        job1.setCompany("LSI Logic");
        job1.setDesignation("Software Engg");
        job1.setId(1);
        job1.setStartDate(LocalDate.of(2007, 10, 1));
        job1.setEndDate(LocalDate.of(2006, 10, 1));
        job1.setCurrentJob(true);
        job1.getResponsibilities().add("UI development");
        job1.getResponsibilities().add("Bug fixing");
        job1.getResponsibilities().add("Testing");
           Job job2 = new Job();
        job2.setCompany("Samsung");
        job2.setDesignation("Sr. Software Engg");
        job2.setId(2);
        job2.setStartDate(LocalDate.of(2005, 5, 1));
        job2.setEndDate(LocalDate.of(2006, 10, 1));
        job2.getResponsibilities().add("DIVx Playback");
        job2.getResponsibilities().add("Bug fixing");
        job2.getResponsibilities().add("Testing");
        
        Education e1 = new Education();
        e1.setCollege("NITK,Surathkal");
        e1.setQualification("B.Tech");
        e1.setSummary("Studied a lot");
        e1.setStartDate(LocalDate.of(2001, 9, 1));
        e1.setEndDate(LocalDate.of(2005, 5, 1));


        Education e2 = new Education();
        e2.setCollege("Gogate College");
        e2.setQualification("12th");
        e2.setSummary("PCMB");
        e2.setStartDate(LocalDate.of(2001, 5, 1));
        e2.setEndDate(LocalDate.of(1999, 07, 1));
        profile1.getEducations().clear();
        profile1.getEducations().add(e1);
        profile1.getEducations().add(e2);
        profile1.getSkills().clear();

        profile1.getSkills().add("JAVA");
        profile1.getSkills().add("SPRING BOOT");
        
        


        
        profile1.getJobs().clear();
        profile1.getJobs().add(job1);
        profile1.getJobs().add(job2);
		userProfileRepository.save(profile1);
		return "profile";
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
