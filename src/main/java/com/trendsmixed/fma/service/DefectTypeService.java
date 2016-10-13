package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.DefectType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.repository.DefectTypeRepository;

@Service
public class DefectTypeService {

    @Autowired
    private DefectTypeRepository defectTypeRepository;

    public List<DefectType> findAll() {
        return defectTypeRepository.findAll();
    }

    public DefectType save(DefectType defectType) {
        return defectTypeRepository.save(defectType);
    }

    public DefectType findOne(int id) {
        return defectTypeRepository.findOne(id);
    }

    public void delete(int id) {
        defectTypeRepository.delete(id);
    }
}
