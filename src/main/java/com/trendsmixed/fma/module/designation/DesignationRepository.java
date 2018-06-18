package com.trendsmixed.fma.module.designation;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface DesignationRepository extends PagingAndSortingRepository<Designation, Integer> {

    Designation findByCode(String code);

    Designation findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM Designation o")
    List<Combo> getCombo();
}
