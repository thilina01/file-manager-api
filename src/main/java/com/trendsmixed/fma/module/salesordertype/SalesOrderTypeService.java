package com.trendsmixed.fma.module.salesordertype;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class SalesOrderTypeService {

    @Autowired
    private SalesOrderTypeRepository repository;

    public Iterable<SalesOrderType> findAll() {
        return repository.findAll();
    }

    public Page<SalesOrderType> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public SalesOrderType save(SalesOrderType salesOrderType) {
        return repository.save(salesOrderType);
    }

    public void save(List<SalesOrderType> salesOrderTypes) {
        repository.save(salesOrderTypes);
    }

    public SalesOrderType findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }
}
