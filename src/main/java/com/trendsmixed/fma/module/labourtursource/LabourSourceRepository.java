package com.trendsmixed.fma.module.labourtursource;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface LabourSourceRepository extends PagingAndSortingRepository<LabourSource, Integer> {

    LabourSource findByCode(String code);

    LabourSource findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM LabourSource o")
    List<Combo> getCombo();
}
