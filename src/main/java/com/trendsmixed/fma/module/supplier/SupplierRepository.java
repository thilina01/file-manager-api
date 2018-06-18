package com.trendsmixed.fma.module.supplier;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface SupplierRepository extends PagingAndSortingRepository<Supplier, Integer> {

    Supplier findByCode(String code);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code,o.name)"
            + " FROM Supplier o")
    List<Combo> getCombo();
}
