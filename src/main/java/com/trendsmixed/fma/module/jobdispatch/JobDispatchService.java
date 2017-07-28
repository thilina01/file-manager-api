package com.trendsmixed.fma.module.jobdispatch;

import com.trendsmixed.fma.module.jobdispatch.JobDispatchRepository;
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
