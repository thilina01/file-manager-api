package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.ControlPointPlanJob;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.repository.ControlPointPlanJobRepository;
import java.util.ArrayList;
import java.util.Date;

@Service
public class ControlPointPlanJobService {

    @Autowired
    private ControlPointPlanJobRepository controlPointPlanJobRepository;

    public List<ControlPointPlanJob> findAll() {
        return controlPointPlanJobRepository.findAll();
    }

    public ControlPointPlanJob save(ControlPointPlanJob ControlPointPlanJob) {
        return controlPointPlanJobRepository.save(ControlPointPlanJob);
    }

    public ControlPointPlanJob findOne(int id) {
        return controlPointPlanJobRepository.findOne(id);
    }

    public void delete(int id) {
        controlPointPlanJobRepository.delete(id);
    }

    public ArrayList findSectionWiseQuantityInPlanDateBetween(Date startDate, Date endDate) {
        return controlPointPlanJobRepository.findSectionWiseQuantityInPlanDateBetween(startDate, endDate);
    }
}
