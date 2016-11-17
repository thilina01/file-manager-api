package com.trendsmixed.fma.repository;

import com.trendsmixed.fma.entity.ControlPointRunManpower;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ControlPointRunManpowerRepository extends JpaRepository<ControlPointRunManpower, Integer> {

    @Query(value = "select cprm.manpowerType.type, sum(cprm.count) as quantity from ControlPointRunManpower cprm where cprm.controlPointRun.runDate between :startDate and :endDate group by cprm.manpowerType")
    public List findSumByManpowerTypeAndDateBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate, Pageable pageable);

}
