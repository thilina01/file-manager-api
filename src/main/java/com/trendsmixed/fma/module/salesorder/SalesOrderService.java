package com.trendsmixed.fma.module.salesorder;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SalesOrderService {

    @Autowired
    private SalesOrderRepository repository;

    public Iterable<SalesOrder> findAll() {
        return repository.findAll();
    }

    public Page<SalesOrder> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public SalesOrder save(SalesOrder SalesOrder) {
        return repository.save(SalesOrder);
    }

    public void save(List<SalesOrder> SalesOrder) {
        repository.save(SalesOrder);
    }

    public SalesOrder findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public SalesOrder findByid(Integer id) {
        return repository.findByid(id);
    }

}
