package com.trendsmixed.fma.module.losstype;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.entity.LossType;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LossTypeRepository extends PagingAndSortingRepository<LossType, Integer> {

    public LossType findByCode(String code);

    public LossType findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM LossType o")
    public List<Combo> getCombo();
}
