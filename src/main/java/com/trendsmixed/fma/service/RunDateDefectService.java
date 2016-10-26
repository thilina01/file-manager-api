package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.RunDateDefect;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.repository.RunDateDefectRepository;

@Service
public class RunDateDefectService {

    @Autowired
    private RunDateDefectRepository runDateDefectRepository;

    public List<RunDateDefect> findAll() {
        return runDateDefectRepository.findAll();
    }

    public RunDateDefect save(RunDateDefect runDateDefect) {
        return runDateDefectRepository.save(runDateDefect);
    }

    public RunDateDefect findOne(int id) {
        return runDateDefectRepository.findOne(id);
    }

    public void delete(int id) {
        runDateDefectRepository.delete(id);
    }
}
