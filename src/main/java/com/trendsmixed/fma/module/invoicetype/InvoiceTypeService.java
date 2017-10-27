package com.trendsmixed.fma.module.invoicetype;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.domain.Page;

@Service
public class InvoiceTypeService {

    @Autowired
    private InvoiceTypeRepository repository;

    public Iterable<InvoiceType> findAll() {
        return repository.findAll();
    }

    public Page<InvoiceType> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public InvoiceType save(InvoiceType invoiceType) {
        return repository.save(invoiceType);
    }

    public void save(List<InvoiceType> items) {
        repository.save(items);
    }

    public InvoiceType findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public InvoiceType findByName(String name) {
        return repository.findByName(name);
    }
}