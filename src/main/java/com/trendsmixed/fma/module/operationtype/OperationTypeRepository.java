package com.trendsmixed.fma.module.operationtype;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.trendsmixed.fma.dao.Combo;

public interface OperationTypeRepository extends PagingAndSortingRepository<OperationType, Integer> {

    OperationType findByCode(String code);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.description)"
            + " FROM OperationType o")
    List<Combo> getCombo();
}
