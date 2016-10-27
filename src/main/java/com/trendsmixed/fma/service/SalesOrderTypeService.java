package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.SalesOrderType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.repository.SalesOrderTypeRepository;

@Service
public class SalesOrderTypeService {

    @Autowired
    private SalesOrderTypeRepository salesOrderTypeRepository;

    public List<SalesOrderType> findAll() {
        return salesOrderTypeRepository.findAll();
    }

    public SalesOrderType save(SalesOrderType salesOrderType) {
        return salesOrderTypeRepository.save(salesOrderType);
    }

    public SalesOrderType findOne(int id) {
        return salesOrderTypeRepository.findOne(id);
    }

    public void delete(int id) {
        salesOrderTypeRepository.delete(id);
    }
}
