package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.PurchaseOrderType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.repository.PurchaseOrderTypeRepository;

@Service
public class PurchaseOrderTypeService {

    @Autowired
    private PurchaseOrderTypeRepository PurchaseOrderTypeRepository;

    public List<PurchaseOrderType> findAll() {
        return PurchaseOrderTypeRepository.findAll();
    }

    public PurchaseOrderType save(PurchaseOrderType purchaseOrderType) {
        return PurchaseOrderTypeRepository.save(purchaseOrderType);
    }

    public PurchaseOrderType findOne(int id) {
        return PurchaseOrderTypeRepository.findOne(id);
    }

    public void delete(int id) {
        PurchaseOrderTypeRepository.delete(id);
    }
}
