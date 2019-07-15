package com.trendsmixed.fma.module.rawmaterialitem;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface RawMaterialItemRepository extends PagingAndSortingRepository<RawMaterialItem, Integer> {

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, '','')"
            + " FROM RawMaterialItem o")
    List<Combo> getCombo();

}
