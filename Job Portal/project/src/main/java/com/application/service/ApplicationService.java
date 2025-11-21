package com.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.model.Application;
import com.application.model.User;
import com.application.repository.ApplicationRepository;
import com.application.repository.JobRepository;
import com.application.repository.UserRepository;

@Service
public class ApplicationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ApplicationRepository applicationRepository;
    

    public Application applyForJob(Long userId, Long jobId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found "));
                
        com.application.model.Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found "));

        Application application = new Application(user, job);
        return applicationRepository.save(application);
    }
}
