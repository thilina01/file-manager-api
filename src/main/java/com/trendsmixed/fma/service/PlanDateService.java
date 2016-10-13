package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.PlanDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.repository.PlanDateRepository;

@Service
public class PlanDateService {

    @Autowired
    private PlanDateRepository planDateRepository;

    public List<PlanDate> findAll() {
        return planDateRepository.findAll();
    }

    public PlanDate save(PlanDate planDate) {
        return planDateRepository.save(planDate);
    }

    public PlanDate findOne(int id) {
        return planDateRepository.findOne(id);
    }

    public void delete(int id) {
        planDateRepository.delete(id);
    }
}
