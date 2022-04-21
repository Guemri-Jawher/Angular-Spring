package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.JobRepository;
import com.example.demo.entity.Jobs;

@Transactional
@Service
public class JobService {
	
	@Autowired
    private JobRepository repository ;
	
	public void saveJob (Jobs job) {
		repository.save(job) ;
	}
	
	public void deleteJobById (Long id) {
		repository.deleteById(id);
	}
	
	public Jobs findJobById (Long id) {
		return repository.findJobById(id);
	}
	
	public List<Jobs> findAllJobs (){
		return repository.findAll();
	}
	
	public List<Jobs> findJobByJob_title (String JobTitle){
		return repository.findJobByJob_title (JobTitle);
	}
	
	public List<Jobs> findJobByLocation (String location){
		return repository.findJobByLocation (location);
	}
	
	public List<Jobs> findJobByJob_titleAndLocation(String JobTitle ,String location){
		return repository.findJobByJob_titleAndLocation(JobTitle ,location);
	}

}
