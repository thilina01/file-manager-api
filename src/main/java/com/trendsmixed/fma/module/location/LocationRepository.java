package com.trendsmixed.fma.module.location;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface LocationRepository extends PagingAndSortingRepository<Location, Integer> {

    Location findByCode(String code);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM Location o")
    List<Combo> getCombo();
}
