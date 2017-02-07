package com.trendsmixed.fma.module.lossreason;

import com.trendsmixed.fma.entity.LossReason;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LossReasonRepository extends JpaRepository<LossReason, Integer> {

    public LossReason findByCode(String code);

}
