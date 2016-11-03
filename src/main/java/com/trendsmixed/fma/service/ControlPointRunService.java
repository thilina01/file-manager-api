package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.ControlPointRun;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.repository.ControlPointRunRepository;

@Service
public class ControlPointRunService {

    @Autowired
    private ControlPointRunRepository controlPointRunRepository;

    public List<ControlPointRun> findAll() {
        return controlPointRunRepository.findAll();
    }

    public ControlPointRun save(ControlPointRun ControlPointRun) {
        return controlPointRunRepository.save(ControlPointRun);
    }

    public ControlPointRun findOne(int id) {
        return controlPointRunRepository.findOne(id);
    }

    public void delete(int id) {
        controlPointRunRepository.delete(id);
    }
}

