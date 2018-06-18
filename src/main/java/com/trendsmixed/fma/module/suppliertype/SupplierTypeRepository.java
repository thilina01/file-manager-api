package com.trendsmixed.fma.module.suppliertype;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface SupplierTypeRepository extends PagingAndSortingRepository<SupplierType, Integer> {

    SupplierType findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM SupplierType o")
    List<Combo> getCombo();
}
