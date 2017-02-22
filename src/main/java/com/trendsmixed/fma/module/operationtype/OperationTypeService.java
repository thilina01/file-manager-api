package com.trendsmixed.fma.module.operationtype;

import com.trendsmixed.fma.entity.OperationType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.module.operationtype.OperationTypeRepository;

@Service
public class OperationTypeService {

    @Autowired
    private OperationTypeRepository operationTypeRepository;

    public List<OperationType> findAll() {
        return operationTypeRepository.findAll();
    }

    public OperationType save(OperationType operationType) {
        return operationTypeRepository.save(operationType);
    }

    public void save(List<OperationType> operationTypes) {
        operationTypeRepository.save(operationTypes);
    }

    public OperationType findOne(int id) {
        return operationTypeRepository.findOne(id);
    }

    public void delete(int id) {
        operationTypeRepository.delete(id);
    }

    public OperationType findByCode(String code) {
        return operationTypeRepository.findByCode(code);
    }

    public OperationType findByDescription(String description) {
        return operationTypeRepository.findByDescription(description);
    }
}
