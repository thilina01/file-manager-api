package com.trendsmixed.fma.module.labourtursource;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LabourSourceRepository extends PagingAndSortingRepository<LabourSource, Integer> {

    LabourSource findByCode(String code);

    LabourSource findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM LabourSource o")
    List<Combo> getCombo();
}
