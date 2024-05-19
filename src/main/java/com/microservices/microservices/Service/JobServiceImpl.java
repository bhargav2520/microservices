package com.microservices.microservices.Service;

import com.microservices.microservices.Controller.Job;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service

public class JobServiceImpl implements JobService{
    public  List<Job> jobs=new ArrayList<>();

    @Override
    public List<Job> findAll() {
        return jobs;    }

    @Override
    public String create(Job job) {
        jobs.add(job);
        return "added successfull";
    }

    @Override
    public boolean delete(Long id) {
        Iterator<Job> interator = jobs.iterator();
        while (interator.hasNext()) {
            Job job = interator.next();
            if (job.getId().equals(id)) {
                interator.remove();
                return true;

            }
        }
 return false;
    }

    @Override
    public Job getJobById(Long id) {
        for(Job job : jobs) {
            if (job.getId().equals(id)){
                return job;
            }
        }
    return null;
    }
}
