package com.trendsmixed.fma.module.subcontractarrival;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.job.Job;
import com.trendsmixed.fma.module.subcontractnote.SubcontractNote;
import com.trendsmixed.fma.module.subcontractor.Subcontractor;

public interface SubcontractArrivalRepository extends PagingAndSortingRepository<SubcontractArrival, Integer> {

        @Query(value = "SELECT" + " new com.trendsmixed.fma.dao.Combo(o.id,CONCAT(o.id,''),'')"
                        + " FROM SubcontractArrival o")
        List<Combo> getCombo();

        Iterable<SubcontractArrival> findBySubcontractOperationSubcontractNote(SubcontractNote subcontractNote);

        Page<SubcontractArrival> findByArrivalTimeBetween(Date startDate, Date endDate, Pageable pageable);

        Page<SubcontractArrival> findBySubcontractOperationSubcontractOperationRateSubcontractorOperationSubcontractorAndArrivalTimeBetween(
                        Subcontractor subcontractor, Date startDate, Date endDate, Pageable pageable);

        Page<SubcontractArrival> findBySubcontractOperationJobAndArrivalTimeBetween(Job job, Date startDate,
                        Date endDate, Pageable pageable);

        Page<SubcontractArrival> findBySubcontractOperationSubcontractOperationRateSubcontractorOperationSubcontractorAndSubcontractOperationJobAndArrivalTimeBetween(
                        Subcontractor subcontractor, Job job, Date startDate, Date endDate, Pageable pageable);

}
