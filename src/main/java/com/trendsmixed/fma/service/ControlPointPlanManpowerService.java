package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.ControlPointPlanManpower;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.repository.ControlPointPlanManpowerRepository;

@Service
public class ControlPointPlanManpowerService {

    @Autowired
    private ControlPointPlanManpowerRepository controlPointPlanManpowerRepository;

    public List<ControlPointPlanManpower> findAll() {
        return controlPointPlanManpowerRepository.findAll();
    }

    public ControlPointPlanManpower save(ControlPointPlanManpower ControlPointPlanManpower) {
        return controlPointPlanManpowerRepository.save(ControlPointPlanManpower);
    }

    public ControlPointPlanManpower findOne(int id) {
        return controlPointPlanManpowerRepository.findOne(id);
    }

    public void delete(int id) {
        controlPointPlanManpowerRepository.delete(id);
    }
}

