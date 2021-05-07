package com.trendsmixed.fma.module.salesperkg;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SalesPerKgService {

    private SalesPerKgRepository repository;

    public Iterable<SalesPerKg> findAll() {
        return repository.findAll();
    }

    public Page<SalesPerKg> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public SalesPerKg save(SalesPerKg salesPerKg) {
        return repository.save(salesPerKg);
    }

    public void save(List<SalesPerKg> salesPerKgs) {
        repository.saveAll(salesPerKgs);
    }

    public SalesPerKg findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

}
