package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.RunDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.repository.RunDateRepository;

@Service
public class RunDateService {

    @Autowired
    private RunDateRepository runDateRepository;

    public List<RunDate> findAll() {
        return runDateRepository.findAll();
    }

    public RunDate save(RunDate runDate) {
        return runDateRepository.save(runDate);
    }

    public RunDate findOne(int id) {
        return runDateRepository.findOne(id);
    }

    public void delete(int id) {
        runDateRepository.delete(id);
    }
}
