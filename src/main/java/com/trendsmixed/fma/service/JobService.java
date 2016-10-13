package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.Job;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.repository.JobRepository;

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

    public Job findOne(int id) {
        return jobRepository.findOne(id);
    }

    public void delete(int id) {
        jobRepository.delete(id);
    }
}
