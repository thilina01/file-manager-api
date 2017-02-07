package com.trendsmixed.fma.module.workcenter;

import com.trendsmixed.fma.entity.WorkCenter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkCenterRepository extends JpaRepository<WorkCenter, Integer> {

    public WorkCenter findByCode(String code);

}
