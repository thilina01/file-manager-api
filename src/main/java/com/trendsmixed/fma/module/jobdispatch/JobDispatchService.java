package com.trendsmixed.fma.module.jobdispatch;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class JobDispatchService {

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
