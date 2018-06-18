package com.trendsmixed.fma.module.workcenter;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface WorkCenterRepository extends PagingAndSortingRepository<WorkCenter, Integer> {

    WorkCenter findByCode(String code);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(workCenter.id, workCenter.code, workCenter.name)"
            + " FROM WorkCenter workCenter")
    List<Combo> getCombo();

}
