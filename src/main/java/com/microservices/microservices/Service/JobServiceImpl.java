package com.microservices.microservices.Service;

import com.microservices.microservices.Controller.Job;
import com.microservices.microservices.Controller.JobRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service

public class JobServiceImpl implements JobService{
 //   public  List<Job> jobs=new ArrayList<>();
    JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();    }

    @Override
    public String create(Job job) {
        jobRepository.save(job);
        return "added successfull";
    }

    @Override
    public boolean delete(Long id) {
       try {
           jobRepository.deleteById(id);
           return true;
       }
       catch(Exception e){
           return false;
        }
    }

    @Override
    public boolean update(Long id, Job updatedjob) {
        Optional<Job> jobOptional=jobRepository.findById(id);
        if(jobOptional.isPresent()){
            Job job=jobOptional.get();
            job.setTitle(updatedjob.getTitle());
            job.setMaxsalary(updatedjob.getMaxsalary());
            job.setLocation(updatedjob.getLocation());
            job.setDescription(updatedjob.getDescription());
            job.setMinsalary(updatedjob.getMinsalary());
return true;
        }
        return false;
    }

    @Override
    public Job getJobById(Long id) {
    return  jobRepository.findById(id).orElse(null);
    }
}
