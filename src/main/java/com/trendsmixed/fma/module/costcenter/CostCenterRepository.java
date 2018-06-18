package com.trendsmixed.fma.module.costcenter;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CostCenterRepository extends PagingAndSortingRepository<CostCenter, Integer> {

    CostCenter findByCode(String code);

    CostCenter findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM CostCenter o")
    List<Combo> getCombo();

}
