package com.trendsmixed.fma.module.operation;

import com.trendsmixed.fma.entity.Operation;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OperationService {

    @Autowired
    private OperationRepository operationRepository;

    public List<Operation> findAll() {
        return operationRepository.findAll();
    }

    public Operation save(Operation operation) {
        return operationRepository.save(operation);
    }

    public void save(List<Operation> operations) {
        operationRepository.save(operations);
    }

    public Operation findOne(int id) {
        return operationRepository.findOne(id);
    }

    public void delete(int id) {
        operationRepository.delete(id);
    }

}
