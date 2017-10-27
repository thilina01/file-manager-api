package com.trendsmixed.fma.module.salesorderitem;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SalesOrderItemService {

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
