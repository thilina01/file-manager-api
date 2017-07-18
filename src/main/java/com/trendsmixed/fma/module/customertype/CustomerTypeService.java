package com.trendsmixed.fma.module.customertype;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.entity.CustomerType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerTypeService {

    @Autowired
    private CustomerTypeRepository repository;

    public Iterable<CustomerType> findAll() {
        return repository.findAll();
    }

    public Page<CustomerType> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public CustomerType save(CustomerType customerType) {
        return repository.save(customerType);
    }

    public CustomerType findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public CustomerType findByCode(String code) {
        return repository.findByCode(code);
    }

    public CustomerType findByName(String name) {
        return repository.findByName(name);
    }
}
