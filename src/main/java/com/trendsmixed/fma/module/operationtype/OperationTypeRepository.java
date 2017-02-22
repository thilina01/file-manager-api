package com.trendsmixed.fma.module.operationtype;

import com.trendsmixed.fma.entity.OperationType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationTypeRepository extends JpaRepository<OperationType, Integer> {

    public OperationType findByCode(String code);

    public OperationType findByDescription(String description);

}
