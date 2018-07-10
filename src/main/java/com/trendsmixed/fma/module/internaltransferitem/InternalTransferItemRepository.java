package com.trendsmixed.fma.module.internaltransferitem;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.trendsmixed.fma.dao.Combo;

public interface InternalTransferItemRepository extends PagingAndSortingRepository<InternalTransferItem, Integer> {

        @Query(value = "SELECT" + " new com.trendsmixed.fma.dao.Combo(o.id,CONCAT(o.id,''),'')"
                        + " FROM InternalTransferItem o")
        List<Combo> getCombo();

}
