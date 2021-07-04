package com.computergurukul.resumeportal.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Job {
	  @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int id;
	    private String company;
	    private String designation;
	    private LocalDate startDate;
	    private LocalDate endDate;
	    private boolean isCurrentJob;
	    @ElementCollection(targetClass=String.class)
	    private List<String> responsibilities = new ArrayList();

	    public List<String> getResponsibilities() {
	        return responsibilities;
	    }

	    public void setResponsibilities(List<String> responsibilities) {
	        this.responsibilities = responsibilities;
	    }
	   
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getCompany() {
			return company;
		}
		public void setCompany(String company) {
			this.company = company;
		}
		public boolean isCurrentJob() {
			return isCurrentJob;
		}
		public void setCurrentJob(boolean isCurrentJob) {
			this.isCurrentJob = isCurrentJob;
		}
		public String getDesignation() {
			return designation;
		}
		public void setDesignation(String designation) {
			this.designation = designation;
		}
		public LocalDate getStartDate() {
			return startDate;
		}
		public void setStartDate(LocalDate startDate) {
			this.startDate = startDate;
		}
		public LocalDate getEndDate() {
			return endDate;
		}
		public void setEndDate(LocalDate endDate) {
			this.endDate = endDate;
		}
		public String getFormattedStartDate() {
	        return startDate.format(DateTimeFormatter.ofPattern("MMM yyyy"));
	    }

	    public String getFormattedEndDate() {
	        return endDate.format(DateTimeFormatter.ofPattern("MMM yyyy"));
	    }

}
