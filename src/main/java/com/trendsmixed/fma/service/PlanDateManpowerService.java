package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.PlanDateManpower;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.repository.PlanDateManpowerRepository;

@Service
public class PlanDateManpowerService {

    @Autowired
    private PlanDateManpowerRepository panDateHasManpowerTypeRepository;

    public List<PlanDateManpower> findAll() {
        return panDateHasManpowerTypeRepository.findAll();
    }

    public PlanDateManpower save(PlanDateManpower planDateManpower) {
        return panDateHasManpowerTypeRepository.save(planDateManpower);
    }

    public PlanDateManpower findOne(int id) {
        return panDateHasManpowerTypeRepository.findOne(id);
    }

    public void delete(int id) {
        panDateHasManpowerTypeRepository.delete(id);
    }
}
