package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.Job;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.repository.JobRepository;
import java.util.Date;
import org.springframework.data.domain.Pageable;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    public Job save(Job job) {
        return jobRepository.save(job);
    }

    public List<Job> save(List<Job> jobs) {
        return jobRepository.save(jobs);
    }

    public Job findOne(int id) {
        return jobRepository.findOne(id);
    }

    public void delete(int id) {
        jobRepository.delete(id);
    }

    public Job findByJobNo(String jobNo) {
        return jobRepository.findByJobNo(jobNo);
    }

    public List findX(Date startDate, Date endDate, Pageable pageable) {
        return jobRepository.findX(startDate, endDate, pageable);
    }

}
