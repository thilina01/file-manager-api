package com.trendsmixed.fma.module.machine;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface MachineRepository extends PagingAndSortingRepository<Machine, Integer> {

    Machine findByCode(String code);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM Machine o")
    List<Combo> getCombo();
}
