package com.trendsmixed.fma.module.shiftroster;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.trendsmixed.fma.dao.Combo;

public interface ShiftRosterRepository extends PagingAndSortingRepository<ShiftRoster, Integer> {

    ShiftRoster findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM ShiftRoster o")
    List<Combo> getCombo();
}
