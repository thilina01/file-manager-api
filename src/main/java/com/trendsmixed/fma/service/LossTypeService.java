package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.LossType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.repository.LossTypeRepository;

@Service
public class LossTypeService {

    @Autowired
    private LossTypeRepository LossTypeRepository;

    public List<LossType> findAll() {
        return LossTypeRepository.findAll();
    }

    public LossType save(LossType lossType) {
        return LossTypeRepository.save(lossType);
    }

    public LossType findOne(int id) {
        return LossTypeRepository.findOne(id);
    }

    public void delete(int id) {
        LossTypeRepository.delete(id);
    }

    public LossType findByCode(String code) {
        return LossTypeRepository.findByCode(code);
    }
}
