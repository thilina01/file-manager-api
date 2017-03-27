package com.trendsmixed.fma.module.operation;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.entity.Operation;

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

	public List test(Date startDate, Date endDate) {
		return operationRepository.test(startDate, endDate);
	}

}
