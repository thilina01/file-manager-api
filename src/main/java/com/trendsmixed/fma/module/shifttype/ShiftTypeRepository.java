package com.trendsmixed.fma.module.shifttype;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.trendsmixed.fma.dao.Combo;

public interface ShiftTypeRepository extends PagingAndSortingRepository<ShiftType, Integer> {

    public ShiftType findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM ShiftType o")
    public List<Combo> getCombo();
}
