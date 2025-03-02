package com.example.demo.repository;

import com.example.demo.model.JobDetails;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JobRepository {

    private final JdbcTemplate jdbcTemplate;

    // Constructor injection for JdbcTemplate
    public JobRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Method to fetch all job details from the database
    public List<JobDetails> findAll() {
        String sql = "SELECT * FROM JobDetails";  // SQL query to fetch all job details
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            JobDetails jobDetails = new JobDetails();
            jobDetails.setJobId(rs.getInt("jobId"));
            jobDetails.setJobTitle(rs.getString("jobTitle"));
            jobDetails.setJobDescription(rs.getString("jobDescription"));
            jobDetails.setSalary(rs.getDouble("salary"));
            jobDetails.setDepartment(rs.getString("department"));
            jobDetails.setJobStatus(rs.getString("jobStatus"));
            jobDetails.setLocation(rs.getString("location"));
            jobDetails.setPostedBy(rs.getString("postedBy"));
            return jobDetails;  // Return the mapped JobDetails object
        });
    }
}
