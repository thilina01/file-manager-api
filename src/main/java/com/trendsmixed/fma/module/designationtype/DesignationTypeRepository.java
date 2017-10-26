package com.trendsmixed.fma.module.designationtype;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.trendsmixed.fma.dao.Combo;

public interface DesignationTypeRepository extends PagingAndSortingRepository<DesignationType, Integer> {

    public DesignationType findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM DesignationType o")
    public List<Combo> getCombo();
}
