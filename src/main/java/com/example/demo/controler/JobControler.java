package com.example.demo.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Jobs;
import com.example.demo.service.JobService;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class JobControler {
	
	@Autowired
	private JobService service;
	
	@PostMapping("/postJob")
	 public String PostJob(@RequestBody Jobs job) {
		 service.saveJob(job);
		 return "Hi " + job.getJob_title() + " your job post process successfully completed";
	 }
	 
	 @GetMapping("/getAllJobs")
	 public List<Jobs> findAllJobs() {
		 return service.findAllJobs();
	 }
	 
	 @GetMapping("/findJobs/{id}")
	 public Jobs findJobById(@PathVariable Long id) {
		 return service.findJobById(id);
	 }
	 
	 @GetMapping("/findJobJL/{job_title}/{location}")
	 public List<Jobs> findJobByTitleAndLocation(@PathVariable String job_title ,@PathVariable String location ) {
		 return service.findJobByJob_titleAndLocation(job_title,location);
	 }
	 
	 @GetMapping("/findJob/{job_title}")
	 public List<Jobs> findJobByTitle(@PathVariable String job_title) {
		 return service.findJobByJob_title(job_title);
	 }

}
