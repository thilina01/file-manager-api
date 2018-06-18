package com.trendsmixed.fma.module.shift;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ShiftRepository extends PagingAndSortingRepository<Shift, Integer> {

    Shift findByCode(String code);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM Shift o")
    List<Combo> getCombo();
}
