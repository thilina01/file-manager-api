package com.trendsmixed.fma.module.dispatch;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DispatchRepository extends PagingAndSortingRepository<Dispatch, Integer> {
    
    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id,'','')"
            + " FROM Dispatch o")
    public List<Combo> getCombo();
}
