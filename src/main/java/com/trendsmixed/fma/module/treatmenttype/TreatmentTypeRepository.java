package com.trendsmixed.fma.module.treatmenttype;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TreatmentTypeRepository extends PagingAndSortingRepository<TreatmentType, Integer> {

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM TreatmentType o")
    List<Combo> getCombo();
}
