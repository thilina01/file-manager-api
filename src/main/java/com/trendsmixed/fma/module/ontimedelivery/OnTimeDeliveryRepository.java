package com.trendsmixed.fma.module.ontimedelivery;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OnTimeDeliveryRepository extends PagingAndSortingRepository<OnTimeDelivery, Integer> {

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, '', '')"
            + " FROM OnTimeDelivery o")
    List<Combo> getCombo();

}
