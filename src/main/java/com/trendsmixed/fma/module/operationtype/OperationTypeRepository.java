package com.trendsmixed.fma.module.operationtype;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface OperationTypeRepository extends PagingAndSortingRepository<OperationType, Integer> {

    OperationType findByCode(String code);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.description)"
            + " FROM OperationType o")
    List<Combo> getCombo();
}
