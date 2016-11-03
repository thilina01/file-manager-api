package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.ControlPointPlan;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.repository.ControlPointPlanRepository;

@Service
public class ControlPointPlanService {

    @Autowired
    private ControlPointPlanRepository controlPointPlanRepository;

    public List<ControlPointPlan> findAll() {
        return controlPointPlanRepository.findAll();
    }

    public ControlPointPlan save(ControlPointPlan ControlPointPlan) {
        return controlPointPlanRepository.save(ControlPointPlan);
    }

    public ControlPointPlan findOne(int id) {
        return controlPointPlanRepository.findOne(id);
    }

    public void delete(int id) {
        controlPointPlanRepository.delete(id);
    }
}

