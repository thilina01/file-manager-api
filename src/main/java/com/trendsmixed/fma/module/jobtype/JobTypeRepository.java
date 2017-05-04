package com.trendsmixed.fma.module.jobtype;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.entity.JobType;

public interface JobTypeRepository extends PagingAndSortingRepository<JobType, Integer> {

    public JobType findByCode(String code);

	@Query(value = "SELECT"
			+ " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.type)"
			+ " FROM JobType o")
	public List<Combo> getCombo();
}
