package com.trendsmixed.fma.module.invoicetype;

import com.trendsmixed.fma.dao.Combo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class InvoiceTypeService {

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

    public void save(List<InvoiceType> invoiceTypes) {
        repository.saveAll(invoiceTypes);
    }

    public InvoiceType findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public InvoiceType findByName(String name) {
        return repository.findByName(name);
    }
}
