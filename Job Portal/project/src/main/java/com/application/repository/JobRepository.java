package com.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.model.Job;

public interface JobRepository extends JpaRepository<Job, Long> {
    
}
