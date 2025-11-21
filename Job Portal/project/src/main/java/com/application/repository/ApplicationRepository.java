package com.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.model.Application;

public interface  ApplicationRepository extends JpaRepository<Application, Long> {
    
}
