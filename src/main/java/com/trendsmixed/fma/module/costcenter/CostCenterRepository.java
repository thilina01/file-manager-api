package com.trendsmixed.fma.module.costcenter;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CostCenterRepository extends PagingAndSortingRepository<CostCenter, Integer> {

    CostCenter findByCode(String code);

    CostCenter findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM CostCenter o")
    List<Combo> getCombo();

}
