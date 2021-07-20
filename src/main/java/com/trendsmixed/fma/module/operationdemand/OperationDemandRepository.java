package com.trendsmixed.fma.module.operationdemand;

import com.trendsmixed.fma.module.job.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OperationDemandRepository extends PagingAndSortingRepository<OperationDemand, Integer> {

    Page<OperationDemand> findByJob(Job job, Pageable pageable);

}
