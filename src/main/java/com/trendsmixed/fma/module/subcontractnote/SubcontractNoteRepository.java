package com.trendsmixed.fma.module.subcontractnote;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.location.Location;
import com.trendsmixed.fma.module.subcontractor.Subcontractor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Date;

public interface SubcontractNoteRepository extends PagingAndSortingRepository<SubcontractNote, Integer> {

        @Query(value = "SELECT" + " new com.trendsmixed.fma.dao.Combo(o.id,CONCAT(o.id,''),'')"
                        + " FROM SubcontractNote o")
        List<Combo> getCombo();

        Page<SubcontractNote> findByNoteTimeBetween(Date startDate, Date endDate, Pageable pageable);

        Page<SubcontractNote> findBySubcontractorAndNoteTimeBetween(Subcontractor subcontractor, Date startDate,
                        Date endDate, Pageable pageable);

        Page<SubcontractNote> findBySubcontractReleaseTimeBetween(Date startDate, Date endDate, Pageable pageable);

        Page<SubcontractNote> findBySubcontractorAndSubcontractReleaseTimeBetween(Subcontractor subcontractor,
                        Date startDate, Date endDate, Pageable pageable);

        Page<SubcontractNote> findByLocationAndSubcontractReleaseTimeBetween(Location location, Date startDate,
                        Date endDate, Pageable pageable);

        Page<SubcontractNote> findByLocationAndSubcontractorAndSubcontractReleaseTimeBetween(Location location,
                        Subcontractor subcontractor, Date startDate, Date endDate, Pageable pageable);

}
