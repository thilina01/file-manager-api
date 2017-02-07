package com.trendsmixed.fma.module.jobtype;

import com.trendsmixed.fma.entity.JobType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobTypeRepository extends JpaRepository<JobType, Integer> {

    public JobType findByCode(String code);

}
