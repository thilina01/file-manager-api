package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.ManpowerType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.repository.ManpowerTypeRepository;

@Service
public class ManpowerTypeService {

    @Autowired
    private ManpowerTypeRepository manpowerTypeRepository;

    public List<ManpowerType> findAll() {
        return manpowerTypeRepository.findAll();
    }

    public ManpowerType save(ManpowerType manpowerType) {
        return manpowerTypeRepository.save(manpowerType);
    }

    public ManpowerType findOne(int id) {
        return manpowerTypeRepository.findOne(id);
    }

    public void delete(int id) {
        manpowerTypeRepository.delete(id);
    }
}
