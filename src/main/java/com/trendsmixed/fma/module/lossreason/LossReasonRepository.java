package com.trendsmixed.fma.module.lossreason;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.losstype.LossType;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface LossReasonRepository extends PagingAndSortingRepository<LossReason, Integer> {

    public LossReason findByCode(String code);

    public LossReason findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM LossReason o")
    public List<Combo> getCombo();

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM LossReason o"
            + " WHERE o.lossType = :lossType")
    public List<Combo> getComboByLossType(@Param("lossType") LossType lossType);

    public Page<LossReason> findByLossType(LossType lossType, Pageable pageable);
}
