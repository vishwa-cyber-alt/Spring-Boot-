package com.example.demo.service;

import com.example.demo.model.JobDetails;
import com.example.demo.repository.JobRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class JobService {
    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }


    public List<JobDetails> getAllPersons() {
        return jobRepository.findAll();
    }
}
