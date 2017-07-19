package com.trendsmixed.fma.module.incoterm;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.entity.Incoterm;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IncotermRepository extends PagingAndSortingRepository<Incoterm, Integer> {

    public Incoterm findByCode(String code);

    public Incoterm findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM Incoterm o")
    public List<Combo> getCombo();
}
