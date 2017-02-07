package com.trendsmixed.fma.module.salesorder;

import com.trendsmixed.fma.entity.SalesOrder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.module.salesorder.SalesOrderRepository;

@Service
public class SalesOrderService {

    @Autowired
    private SalesOrderRepository salesOrdereRepository;

    public List<SalesOrder> findAll() {
        return salesOrdereRepository.findAll();
    }

    public SalesOrder save(SalesOrder salesOrder) {
        return salesOrdereRepository.save(salesOrder);
    }

    public SalesOrder findOne(int id) {
        return salesOrdereRepository.findOne(id);
    }

    public void delete(int id) {
        salesOrdereRepository.delete(id);
    }
}
