package com.trendsmixed.fma.module.job;

import com.trendsmixed.fma.entity.Job;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JobRepository extends JpaRepository<Job, Integer> {

	public Job findByJobNo(String jobNo);

	@Query(value = "select j.item.code, sum(j.quantity) as quantity from Job j where j.jobDate between :startDate and :endDate group by j.item order by quantity desc")
	public List findX(@Param("startDate") Date startDate, @Param("endDate") Date endDate, Pageable pageable);

	@Query(value = "select j.id as id, j.jobNo as jobNo, j.jobDate as jobDate,  j.jobType.type as jobType,  j.item.code as itemCode from Job j")
	public List findForTable();

}
