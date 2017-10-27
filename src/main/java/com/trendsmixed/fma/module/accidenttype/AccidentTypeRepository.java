package com.trendsmixed.fma.module.accidenttype;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.trendsmixed.fma.dao.Combo;

public interface AccidentTypeRepository extends PagingAndSortingRepository<AccidentType, Integer> {

    AccidentType findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM AccidentType  o")
    List<Combo> getCombo();
}
