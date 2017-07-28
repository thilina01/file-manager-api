package com.trendsmixed.fma.module.salesorderitem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.module.salesorderitem.SalesOrderItemRepository;

@Service
public class SalesOrderItemService {

    @Autowired
    private SalesOrderItemRepository salesOrderItemRepository;

    public List<SalesOrderItem> findAll() {
        return salesOrderItemRepository.findAll();
    }

    public SalesOrderItem save(SalesOrderItem salesOrderItem) {
        return salesOrderItemRepository.save(salesOrderItem);
    }

    public SalesOrderItem findOne(int id) {
        return salesOrderItemRepository.findOne(id);
    }

    public void delete(int id) {
        salesOrderItemRepository.delete(id);
    }
}
