package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.ControlPointRunBreakdown;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.repository.ControlPointRunBreakdownRepository;

@Service
public class ControlPointRunBreakdownService {

    @Autowired
    private ControlPointRunBreakdownRepository controlPointRunBreakdownRepository;

    public List<ControlPointRunBreakdown> findAll() {
        return controlPointRunBreakdownRepository.findAll();
    }

    public ControlPointRunBreakdown save(ControlPointRunBreakdown ControlPointRunBreakdown) {
        return controlPointRunBreakdownRepository.save(ControlPointRunBreakdown);
    }

    public ControlPointRunBreakdown findOne(int id) {
        return controlPointRunBreakdownRepository.findOne(id);
    }

    public void delete(int id) {
        controlPointRunBreakdownRepository.delete(id);
    }
}

