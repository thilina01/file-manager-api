package com.trendsmixed.fma.module.drawingchangerequest;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.trendsmixed.fma.dao.Combo;

public interface DrawingChangeRequestRepository extends PagingAndSortingRepository<DrawingChangeRequest, Integer> {

        @Query(value = "SELECT" + " new com.trendsmixed.fma.dao.Combo(o.id,CONCAT(o.id,''),'')"
                        + " FROM DrawingChangeRequest o")
        List<Combo> getCombo();

}
