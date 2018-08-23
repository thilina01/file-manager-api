package com.trendsmixed.fma.module.subcontractarrivalreject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.job.Job;
import com.trendsmixed.fma.module.subcontractor.Subcontractor;

public interface SubcontractArrivalRejectRepository
                extends PagingAndSortingRepository<SubcontractArrivalReject, Integer> {

        @Query(value = "SELECT" + " new com.trendsmixed.fma.dao.Combo(o.id,CONCAT(o.id,''),'')"
                        + " FROM SubcontractArrivalReject o")
        List<Combo> getCombo();

        Iterable<SubcontractArrivalReject> findBySubcontractArrivalSubcontractOperationSubcontractOperationRateSubcontractorOperationSubcontractor(
                        Subcontractor subcontractor);

        Page<SubcontractArrivalReject> findByArrivalRejectDateBetween(Date startDate, Date endDate, Pageable pageable);

        Page<SubcontractArrivalReject> findBySubcontractArrivalSubcontractOperationSubcontractOperationRateSubcontractorOperationSubcontractorAndArrivalRejectDateBetween(
                        Subcontractor subcontractor, Date startDate, Date endDate, Pageable pageable);

        Page<SubcontractArrivalReject> findBySubcontractArrivalSubcontractOperationJobAndArrivalRejectDateBetween(
                        Job job, Date startDate, Date endDate, Pageable pageable);

        Page<SubcontractArrivalReject> findBySubcontractArrivalSubcontractOperationSubcontractOperationRateSubcontractorOperationSubcontractorAndSubcontractArrivalSubcontractOperationJobAndArrivalRejectDateBetween(
                        Subcontractor subcontractor, Job job, Date startDate, Date endDate, Pageable pageable);

}
