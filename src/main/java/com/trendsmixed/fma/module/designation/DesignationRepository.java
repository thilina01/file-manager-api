package com.trendsmixed.fma.module.designation;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.trendsmixed.fma.dao.Combo;

public interface DesignationRepository extends PagingAndSortingRepository<Designation, Integer> {

    Designation findByCode(String code);

    Designation findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM Designation o")
    List<Combo> getCombo();
}
