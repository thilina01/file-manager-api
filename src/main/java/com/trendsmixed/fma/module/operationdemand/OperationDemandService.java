package com.trendsmixed.fma.module.operationdemand;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class OperationDemandService {

    private OperationDemandRepository repository;

    public Iterable<OperationDemand> findAll() {
        return repository.findAll();
    }

    public Page<OperationDemand> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public OperationDemand save(OperationDemand operationDemand) {
        return repository.save(operationDemand);
    }

    public void save(List<OperationDemand> operationDemands) {
        repository.saveAll(operationDemands);
    }

    public OperationDemand findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

}
