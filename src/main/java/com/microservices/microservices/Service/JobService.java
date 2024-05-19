package com.microservices.microservices.Service;

import com.microservices.microservices.Controller.Job;
import org.springframework.context.annotation.Bean;

import java.util.List;


public interface JobService {
    List<Job> findAll();
    String create(Job job);
    boolean delete(Long id);


    Job getJobById(Long id);
}
