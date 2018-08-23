package com.trendsmixed.fma.module.subcontractreworknote;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.location.Location;
import com.trendsmixed.fma.module.subcontractor.Subcontractor;

public interface SubcontractReworkNoteRepository extends PagingAndSortingRepository<SubcontractReworkNote, Integer> {

        @Query(value = "SELECT" + " new com.trendsmixed.fma.dao.Combo(o.id,CONCAT(o.id,''),'')"
                        + " FROM SubcontractReworkNote o")
        List<Combo> getCombo();

        Page<SubcontractReworkNote> findByNoteTimeBetween(Date startDate, Date endDate, Pageable pageable);

        Page<SubcontractReworkNote> findBySubcontractorAndNoteTimeBetween(Subcontractor subcontractor, Date startDate,
                        Date endDate, Pageable pageable);

        Page<SubcontractReworkNote> findBySubcontractReleaseTimeBetween(Date startDate, Date endDate, Pageable pageable);

        Page<SubcontractReworkNote> findBySubcontractorAndSubcontractReleaseTimeBetween(Subcontractor subcontractor,
                        Date startDate, Date endDate, Pageable pageable);

        Page<SubcontractReworkNote> findByLocationAndSubcontractReleaseTimeBetween(Location location, Date startDate,
                        Date endDate, Pageable pageable);

        Page<SubcontractReworkNote> findByLocationAndSubcontractorAndSubcontractReleaseTimeBetween(Location location,
                        Subcontractor subcontractor, Date startDate, Date endDate, Pageable pageable);

}
