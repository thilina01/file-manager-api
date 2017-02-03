package com.trendsmixed.fma.repository;

import com.trendsmixed.fma.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation, Integer> {

    public Operation findByCode(String code);

    public Operation findByDescription(String description);

}
