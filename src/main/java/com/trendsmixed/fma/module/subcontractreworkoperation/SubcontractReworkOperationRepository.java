package com.trendsmixed.fma.module.subcontractreworkoperation;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.trendsmixed.fma.dao.Combo;

public interface SubcontractReworkOperationRepository extends PagingAndSortingRepository<SubcontractReworkOperation, Integer> {

        @Query(value = "SELECT" + " new com.trendsmixed.fma.dao.Combo(o.id,CONCAT(o.id,''),'')"
                        + " FROM SubcontractReworkOperation o")
        List<Combo> getCombo();

}
