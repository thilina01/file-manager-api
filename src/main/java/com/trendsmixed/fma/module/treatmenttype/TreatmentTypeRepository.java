package com.trendsmixed.fma.module.treatmenttype;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.trendsmixed.fma.dao.Combo;

public interface TreatmentTypeRepository extends PagingAndSortingRepository<TreatmentType, Integer> {

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM TreatmentType o")
    List<Combo> getCombo();
}
