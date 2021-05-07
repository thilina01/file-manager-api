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

    public JobDispatch findById(int id) {
        return jobDispatchRepository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        jobDispatchRepository.deleteById(id);
    }
}
