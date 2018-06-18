package com.trendsmixed.fma.module.paint;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PaintRepository extends PagingAndSortingRepository<Paint, Integer> {

    Paint findByCode(String code);

    Paint findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM Paint o")
    public List<Combo> getCombo();
}
