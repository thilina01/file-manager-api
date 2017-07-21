package com.trendsmixed.fma.module.costcenter;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.entity.CostCenter;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CostCenterRepository extends PagingAndSortingRepository<CostCenter, Integer> {

    public CostCenter findByCode(String code);

    public CostCenter findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM CostCenter o")
    public List<Combo> getCombo();

}
