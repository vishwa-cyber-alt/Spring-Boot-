package com.example.demo.controller;
import com.example.demo.model.JobDetails;
import com.example.demo.model.Person;
import com.example.demo.service.JobService;
import com.example.demo.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {
    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public List<JobDetails> getAllPersons() {
        return jobService.getAllPersons();
    }
}
