package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.OrderType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.repository.OrderTypeRepository;

@Service
public class OrderTypeService {

    @Autowired
    private OrderTypeRepository OrderTypeRepository;

    public List<OrderType> findAll() {
        return OrderTypeRepository.findAll();
    }

    public OrderType save(OrderType orderType) {
        return OrderTypeRepository.save(orderType);
    }

    public OrderType findOne(int id) {
        return OrderTypeRepository.findOne(id);
    }

    public void delete(int id) {
        OrderTypeRepository.delete(id);
    }
}
