package com.trendsmixed.fma.module.suppliertype;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.trendsmixed.fma.dao.Combo;

public interface SupplierTypeRepository extends PagingAndSortingRepository<SupplierType, Integer> {

    public SupplierType findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM SupplierType o")
    public List<Combo> getCombo();
}
