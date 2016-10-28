package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.JobType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.repository.JobTypeRepository;

@Service
public class JobTypeService {

    @Autowired
    private JobTypeRepository JobTypeRepository;

    public List<JobType> findAll() {
        return JobTypeRepository.findAll();
    }

    public JobType save(JobType jobType) {
        return JobTypeRepository.save(jobType);
    }

    public JobType findOne(int id) {
        return JobTypeRepository.findOne(id);
    }

    public void delete(int id) {
        JobTypeRepository.delete(id);
    }
}
