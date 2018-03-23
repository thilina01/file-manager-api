package com.trendsmixed.fma.module.loadingplanitem;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.trendsmixed.fma.dao.Combo;

public interface LoadingPlanItemRepository extends PagingAndSortingRepository<LoadingPlanItem, Integer> {

    @Query(value = "SELECT" + " new com.trendsmixed.fma.dao.Combo(o.id,'','')" + " FROM LoadingPlanItem o")
    List<Combo> getCombo();
}
