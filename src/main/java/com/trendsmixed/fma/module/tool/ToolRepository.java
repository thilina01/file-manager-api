package com.trendsmixed.fma.module.tool;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ToolRepository extends PagingAndSortingRepository<Tool, Integer> {

    Tool findByCode(String code);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM Tool o")
    List<Combo> getCombo();
}
