package com.trendsmixed.fma.module.accident;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AccidentRepository extends PagingAndSortingRepository<Accident, Integer> {

    Accident findByCode(String code);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, '')"
            + " FROM Accident o")
    List<Combo> getCombo();
}
