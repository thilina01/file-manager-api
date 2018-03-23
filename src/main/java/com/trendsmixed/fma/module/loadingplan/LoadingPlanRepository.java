package com.trendsmixed.fma.module.loadingplan;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.trendsmixed.fma.dao.Combo;

public interface LoadingPlanRepository extends PagingAndSortingRepository<LoadingPlan, Integer> {

    @Query(value = "SELECT" + " new com.trendsmixed.fma.dao.Combo(o.id, '', '')" + " FROM LoadingPlan o")
    List<Combo> getCombo();
}
