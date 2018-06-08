package com.trendsmixed.fma.module.subcontractor;
import com.trendsmixed.fma.dao.Combo;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SubcontractorRepository extends PagingAndSortingRepository<Subcontractor, Integer> {

    @Query(value = "SELECT" + " new com.trendsmixed.fma.dao.Combo(o.id, o.name, '')" + " FROM Subcontractor o")
    List<Combo> getCombo();


}
