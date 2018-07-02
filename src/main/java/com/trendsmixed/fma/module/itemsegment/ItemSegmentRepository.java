package com.trendsmixed.fma.module.itemsegment;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ItemSegmentRepository extends PagingAndSortingRepository<ItemSegment, Integer> {

    ItemSegment findByCode(String code);

    ItemSegment findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM ItemSegment o")
    List<Combo> getCombo();
}
