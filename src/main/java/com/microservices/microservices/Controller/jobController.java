package com.microservices.microservices.Controller;

import com.microservices.microservices.Service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class jobController {
private JobService jobservice;
// hello bargav
public jobController(JobService jobservice) {
    this.jobservice = jobservice;
}
 @GetMapping("/jobs")
 public ResponseEntity<List<Job>> findAll(){

     return ResponseEntity.ok(jobservice.findAll());
 }



    @PostMapping("/jobs")

    public ResponseEntity<String> create(@RequestBody Job job){
     jobservice.create(job);
        return new ResponseEntity<>("added succesfully", HttpStatus.OK);
 }
    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
     boolean stat=jobservice.delete(id);
        return new ResponseEntity<>("job deleted succesfully", HttpStatus.OK);
    }
    @PutMapping("/jobs/{id}")
    public ResponseEntity<String> update(@PathVariable Long id,@RequestBody Job job){
        boolean stat=jobservice.update(id,job);
        return new ResponseEntity<>("job updated succesfully", HttpStatus.OK);
    }
    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
    Job job=jobservice.getJobById(id);

    if(job!=null){
        return new ResponseEntity<>(job, HttpStatus.OK);
    }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
