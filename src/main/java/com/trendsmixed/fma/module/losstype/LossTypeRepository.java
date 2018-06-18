package com.trendsmixed.fma.module.losstype;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface LossTypeRepository extends PagingAndSortingRepository<LossType, Integer> {

    LossType findByCode(String code);

    LossType findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM LossType o")
    List<Combo> getCombo();
}
