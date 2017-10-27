package com.trendsmixed.fma.module.incoterm;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IncotermRepository extends PagingAndSortingRepository<Incoterm, Integer> {

    Incoterm findByCode(String code);

    Incoterm findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM Incoterm o")
    List<Combo> getCombo();
}
