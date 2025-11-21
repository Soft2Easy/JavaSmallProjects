package com.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.model.Application;
import com.application.service.ApplicationService;

import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/application")
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;

    @PostMapping("apply/{userId}/{jobId}")
    public ResponseEntity<Application> applyForJob(@PathVariable Long userId, @PathVariable Long jobId) {
        return ResponseEntity.ok(applicationService.applyForJob(userId, jobId));
    }
    
}
