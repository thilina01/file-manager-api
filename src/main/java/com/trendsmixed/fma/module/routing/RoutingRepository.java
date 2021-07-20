package com.trendsmixed.fma.module.routing;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface RoutingRepository extends PagingAndSortingRepository<Routing, Integer> {

    @Query(value = "SELECT" + " new com.trendsmixed.fma.dao.Combo(o.id, '', '')" + " FROM Routing o")
    List<Combo> getCombo();

}
