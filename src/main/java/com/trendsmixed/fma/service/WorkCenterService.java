package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.WorkCenter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.repository.WorkCenterRepository;

@Service
public class WorkCenterService {

    @Autowired
    private WorkCenterRepository workCenterRepository;

    public List<WorkCenter> findAll() {
        return workCenterRepository.findAll();
    }

    public WorkCenter save(WorkCenter workCenter) {
        return workCenterRepository.save(workCenter);
    }

    public WorkCenter findOne(int id) {
        return workCenterRepository.findOne(id);
    }

    public void delete(int id) {
        workCenterRepository.delete(id);
    }
}
