package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.SaleType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.repository.SaleTypeRepository;

@Service
public class SaleTypeService {

    @Autowired
    private SaleTypeRepository saleTypeRepository;

    public List<SaleType> findAll() {
        return saleTypeRepository.findAll();
    }

    public SaleType save(SaleType saleType) {
        return saleTypeRepository.save(saleType);
    }

    public SaleType findOne(int id) {
        return saleTypeRepository.findOne(id);
    }

    public void delete(int id) {
        saleTypeRepository.delete(id);
    }

    public SaleType findByCode(String code) {
        return saleTypeRepository.findByCode(code);
    }
}
