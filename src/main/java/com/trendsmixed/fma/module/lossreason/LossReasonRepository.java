package com.trendsmixed.fma.module.lossreason;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LossReasonRepository extends JpaRepository<LossReason, Integer> {

    public LossReason findByCode(String code);

}
