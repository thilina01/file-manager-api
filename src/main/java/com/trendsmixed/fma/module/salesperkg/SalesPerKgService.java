package com.trendsmixed.fma.module.salesperkg;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
        repository.save(salesPerKgs);
    }

    public SalesPerKg findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

}
