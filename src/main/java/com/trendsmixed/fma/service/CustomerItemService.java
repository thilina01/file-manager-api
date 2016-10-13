package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.CustomerItem;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.repository.CustomerItemRepository;

@Service
public class CustomerItemService {

    @Autowired
    private CustomerItemRepository defectTypeRepository;

    public List<CustomerItem> findAll() {
        return defectTypeRepository.findAll();
    }

    public CustomerItem save(CustomerItem customerItem) {
        return defectTypeRepository.save(customerItem);
    }

    public CustomerItem findOne(int id) {
        return defectTypeRepository.findOne(id);
    }

    public void delete(int id) {
        defectTypeRepository.delete(id);
    }
}
