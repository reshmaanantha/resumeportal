package com.computergurukul.resumeportal.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


	@Entity
	@Table
	public class UserProfile {
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int id;
	    private String userName;
	    private int theme;
	    private String summary;
	    private String firstName;
	    private String lastName;
	    private String email;
	    private String phone;
	    private String designation;
	    
	    @OneToMany(cascade=CascadeType.ALL,orphanRemoval=true)
	    @JoinColumn(name="job_id")
	    List<Job> jobs=new ArrayList<>();
	    
	    public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getDesignation() {
			return designation;
		}
		public void setDesignation(String designation) {
			this.designation = designation;
		}
		public List<Job> getJobs() {
			return jobs;
		}
		public void setJobs(List<Job> jobs) {
			this.jobs = jobs;
		}
		
	   
	    public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		 
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getTheme() {
			return theme;
		}
		public void setTheme(int theme) {
			this.theme = theme;
		}
		public String getSummary() {
			return summary;
		}
		public void setSummary(String summary) {
			this.summary = summary;
		}
	    
	   
}
