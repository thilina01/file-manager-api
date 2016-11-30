package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.JobDispatch;
import com.trendsmixed.fma.repository.JobDispatchRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobDispatchService {

    @Autowired
    private JobDispatchRepository jobDispatchRepository;

    public List< JobDispatch> findAll() {
        return jobDispatchRepository.findAll();
    }

    public JobDispatch save(JobDispatch dispatch) {
        return jobDispatchRepository.save(dispatch);
    }

    public JobDispatch findOne(int id) {
        return jobDispatchRepository.findOne(id);
    }

    public void delete(int id) {
        jobDispatchRepository.delete(id);
    }
}
