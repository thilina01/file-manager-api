package com.trendsmixed.fma.module.packinglist;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PackingListRepository extends PagingAndSortingRepository<PackingList, Integer> {

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id,'','')"
            + " FROM PackingList o")
    List<Combo> getCombo();

    PackingList findById(String id);

}
