package com.trendsmixed.fma.module.operationtype;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.entity.OperationType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.utility.Page;

@Service
public class OperationTypeService {

    @Autowired
    private OperationTypeRepository repository;

    public Iterable<OperationType> findAll() {
        return repository.findAll();
    }

    public Page<OperationType> findAll(Pageable pageable) {
        return new Page<OperationType>(repository.findAll(pageable));
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public OperationType save(OperationType operationType) {
        return repository.save(operationType);
    }

    public OperationType findOne(int id) {
        return repository.findOne(id);
    }

    public OperationType findByCode(String code) {
        return repository.findByCode(code);
    }

    public void delete(int id) {
        repository.delete(id);
    }

}
