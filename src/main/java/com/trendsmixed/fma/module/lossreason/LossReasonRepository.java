package com.trendsmixed.fma.module.lossreason;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LossReasonRepository extends PagingAndSortingRepository<LossReason, Integer> {

    public LossReason findByCode(String code);

    public LossReason findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM LossReason o")
    public List<Combo> getCombo();
}
