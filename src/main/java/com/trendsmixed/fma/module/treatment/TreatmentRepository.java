package com.trendsmixed.fma.module.treatment;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TreatmentRepository extends PagingAndSortingRepository<Treatment, Integer> {

    Treatment findByCode(String code);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.description)"
            + " FROM Treatment o")
    List<Combo> getCombo();
}
