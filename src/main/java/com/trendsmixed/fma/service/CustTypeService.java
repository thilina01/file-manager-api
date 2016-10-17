package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.CustType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.repository.CustTypeRepository;

@Service
public class CustTypeService {

    @Autowired
    private CustTypeRepository custTypeRepository;

    public List<CustType> findAll() {
        return custTypeRepository.findAll();
    }

    public CustType save(CustType custType) {
        return custTypeRepository.save(custType);
    }

    public CustType findOne(int id) {
        return custTypeRepository.findOne(id);
    }

    public void delete(int id) {
        custTypeRepository.delete(id);
    }
}
