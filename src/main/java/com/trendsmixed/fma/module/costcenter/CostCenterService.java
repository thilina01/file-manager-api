package com.trendsmixed.fma.module.costcenter;

import com.trendsmixed.fma.entity.CostCenter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.module.costcenter.CostCenterRepository;

@Service
public class CostCenterService {

    @Autowired
    private CostCenterRepository costCenterRepository;

    public List<CostCenter> findAll() {
        return costCenterRepository.findAll();
    }

    public CostCenter save(CostCenter costCenter) {
        return costCenterRepository.save(costCenter);
    }

    public void save(List<CostCenter> costCenters) {
        costCenterRepository.save(costCenters);
    }

    public CostCenter findOne(int id) {
        return costCenterRepository.findOne(id);
    }

    public void delete(int id) {
        costCenterRepository.delete(id);
    }

    public CostCenter findByCode(String code) {
        return costCenterRepository.findByCode(code);
    }

}
