package com.trendsmixed.fma.module.job;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.trendsmixed.fma.dao.Combo;

public interface JobRepository extends PagingAndSortingRepository<Job, Integer> {

    public Job findByJobNo(String jobNo);

    @Query(value = "select j.item.code, sum(j.quantity) as quantity from Job j where j.jobDate between :startDate and :endDate group by j.item order by quantity desc")
    public List findX(@Param("startDate") Date startDate, @Param("endDate") Date endDate, Pageable pageable);

    @Query(value = "select j.id as id, j.jobNo as jobNo, j.jobDate as jobDate,  j.jobType.name as jobType,  j.item.code as itemCode from Job j")
    public List findForTable();

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.jobNo, o.item.description)"
            + " FROM Job o")
    public List<Combo> getCombo();

}
