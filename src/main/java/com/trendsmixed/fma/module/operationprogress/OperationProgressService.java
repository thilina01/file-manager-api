package com.trendsmixed.fma.module.operationprogress;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.trendsmixed.fma.dao.Combo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;

@AllArgsConstructor
@Service
public class OperationProgressService {

    private OperationProgressRepository repository;

    public Iterable<OperationProgress> findAll() {
        return repository.findAll();
    }

    public Page<OperationProgress> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public OperationProgress save(OperationProgress operationProgress) {
        return repository.save(operationProgress);
    }

    public void save(List<OperationProgress> items) {
        repository.save(items);
    }

    public OperationProgress findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

}
