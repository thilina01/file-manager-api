package com.trendsmixed.fma.module.subcontractor;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface SubcontractorRepository extends PagingAndSortingRepository<Subcontractor, Integer> {

    @Query(value = "SELECT" + " new com.trendsmixed.fma.dao.Combo(o.id, o.code,o.name)" + " FROM Subcontractor o")
    List<Combo> getCombo();

}
