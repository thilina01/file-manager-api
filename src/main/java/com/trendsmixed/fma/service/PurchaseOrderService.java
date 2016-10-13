package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.PurchaseOrder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.repository.PurchaseOrderRepository;

@Service
public class PurchaseOrderService {

    @Autowired
    private PurchaseOrderRepository purchaseOrdereRepository;

    public List<PurchaseOrder> findAll() {
        return purchaseOrdereRepository.findAll();
    }

    public PurchaseOrder save(PurchaseOrder purchaseOrder) {
        return purchaseOrdereRepository.save(purchaseOrder);
    }

    public PurchaseOrder findOne(int id) {
        return purchaseOrdereRepository.findOne(id);
    }

    public void delete(int id) {
        purchaseOrdereRepository.delete(id);
    }
}
