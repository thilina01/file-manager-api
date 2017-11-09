package com.trendsmixed.fma.module.port;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.trendsmixed.fma.dao.Combo;

public interface PortRepository extends PagingAndSortingRepository<Port, Integer> {

    Port findByCode(String code);

    Port findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM Port o")
    public List<Combo> getCombo();
}
