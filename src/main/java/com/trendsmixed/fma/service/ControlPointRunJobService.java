package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.ControlPointRunJob;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.repository.ControlPointRunJobRepository;

@Service
public class ControlPointRunJobService {

    @Autowired
    private ControlPointRunJobRepository controlPointRunJobRepository;

    public List<ControlPointRunJob> findAll() {
        return controlPointRunJobRepository.findAll();
    }

    public ControlPointRunJob save(ControlPointRunJob ControlPointRunJob) {
        return controlPointRunJobRepository.save(ControlPointRunJob);
    }

    public ControlPointRunJob findOne(int id) {
        return controlPointRunJobRepository.findOne(id);
    }

    public void delete(int id) {
        controlPointRunJobRepository.delete(id);
    }
}

