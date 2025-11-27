package com.application.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.model.Application;
import com.application.service.ApplicationService;


 
@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

	@Autowired
	private ApplicationService applicationService; 
	
	// Apply for a job - must be called only by LoggedIn users
	@PostMapping("/apply/{jobId}") // Path variable correctly mapped
	public ResponseEntity<Application> applyForJob(
				 Principal principal,
				@PathVariable Long jobId ) {
		    
		String username = principal.getName(); 
		
		return ResponseEntity
		    			.ok(applicationService.applyForJob(username, jobId));
		}
}
