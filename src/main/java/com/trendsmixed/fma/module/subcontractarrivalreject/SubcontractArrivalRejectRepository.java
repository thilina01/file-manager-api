package com.trendsmixed.fma.module.subcontractarrivalreject;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.trendsmixed.fma.dao.Combo;

public interface SubcontractArrivalRejectRepository
                extends PagingAndSortingRepository<SubcontractArrivalReject, Integer> {

        @Query(value = "SELECT" + " new com.trendsmixed.fma.dao.Combo(o.id,CONCAT(o.id,''),'')"
                        + " FROM SubcontractArrivalReject o")
        List<Combo> getCombo();

}
