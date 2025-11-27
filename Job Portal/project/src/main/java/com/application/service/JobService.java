package com.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.model.Job;
import com.application.repository.JobRepository;


@Service
public class JobService {

	@Autowired
    private JobRepository jobRepository;

    //Create a new Job
    public Job createJob(Job job) {
        return jobRepository.save(job); // save(T) method from JPARepository
    }
    
    // Get all jobs
    public List<Job> getAllJobs() {
        return jobRepository.findAll();// findAll() method from JPARepository
    }
}
