package com.trendsmixed.fma.module.shifttype;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ShiftTypeRepository extends PagingAndSortingRepository<ShiftType, Integer> {

    ShiftType findByCode(String code);

    ShiftType findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM ShiftType o")
    List<Combo> getCombo();
}
