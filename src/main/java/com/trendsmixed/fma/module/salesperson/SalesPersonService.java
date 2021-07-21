package com.trendsmixed.fma.module.salesperson;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SalesPersonService {

    private SalesPersonRepository repository;

    public Iterable<SalesPerson> findAll() {
        return repository.findAll();
    }

    public Page<SalesPerson> findAll(Pageable pageable) {
        return new Page<SalesPerson>(repository.findAll(pageable));
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public SalesPerson save(SalesPerson salesPerson) {
        return repository.save(salesPerson);
    }

    public SalesPerson findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public SalesPerson findByCode(String code) {
        return repository.findByCode(code);
    }
}
