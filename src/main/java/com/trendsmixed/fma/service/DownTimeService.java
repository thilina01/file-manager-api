package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.DownTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.repository.DownTimeRepository;

@Service
public class DownTimeService {

    @Autowired
    private DownTimeRepository defectTypeRepository;

    public List<DownTime> findAll() {
        return defectTypeRepository.findAll();
    }

    public DownTime save(DownTime downTime) {
        return defectTypeRepository.save(downTime);
    }

    public DownTime findOne(int id) {
        return defectTypeRepository.findOne(id);
    }

    public void delete(int id) {
        defectTypeRepository.delete(id);
    }
}
