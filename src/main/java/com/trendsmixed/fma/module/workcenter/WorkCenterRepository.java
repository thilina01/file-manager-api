package com.trendsmixed.fma.module.workcenter;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.trendsmixed.fma.dao.Combo;

public interface WorkCenterRepository extends PagingAndSortingRepository<WorkCenter, Integer> {

    public WorkCenter findByCode(String code);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(workCenter.id, workCenter.code, workCenter.name)"
            + " FROM WorkCenter workCenter")
    public List<Combo> getCombo();

}
