package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.JobControlPoint;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.repository.JobControlPointRepository;

@Service
public class JobControlPointService {

    @Autowired
    private JobControlPointRepository jobJobControlPointRepository;

    public List<JobControlPoint> findAll() {
        return jobJobControlPointRepository.findAll();
    }

    public JobControlPoint save(JobControlPoint JobControlPoint) {
        return jobJobControlPointRepository.save(JobControlPoint);
    }

    public JobControlPoint findOne(int id) {
        return jobJobControlPointRepository.findOne(id);
    }

    public void delete(int id) {
        jobJobControlPointRepository.delete(id);
    }
}

