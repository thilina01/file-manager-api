package com.trendsmixed.fma.module.warehouse;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface WarehouseRepository extends PagingAndSortingRepository<Warehouse, Integer> {

    Warehouse findByCode(String code);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM Warehouse o")
    List<Combo> getCombo();
}
