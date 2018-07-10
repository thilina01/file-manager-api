package com.trendsmixed.fma.module.internaltransfernote;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.location.Location;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Date;

public interface InternalTransferNoteRepository extends PagingAndSortingRepository<InternalTransferNote, Integer> {

        @Query(value = "SELECT" + " new com.trendsmixed.fma.dao.Combo(o.id,CONCAT(o.id,''),'')"
                        + " FROM InternalTransferNote o")
        List<Combo> getCombo();

        Page<InternalTransferNote> findByArrivalTimeBetween(Date startDate, Date endDate, Pageable pageable);

        Page<InternalTransferNote> findByReleaseTimeBetween(Date startDate, Date endDate, Pageable pageable);

        Page<InternalTransferNote> findByNoteDateBetween(Date startDate, Date endDate, Pageable pageable);

        Page<InternalTransferNote> findByToLocationAndNoteDateBetween(Location toLocation, Date startDate, Date endDate,
                        Pageable pageable);

        Page<InternalTransferNote> findByFromLocationAndNoteDateBetween(Location fromLocation, Date startDate,
                        Date endDate, Pageable pageable);

        Page<InternalTransferNote> findByFromLocationAndToLocationAndNoteDateBetween(Location fromLocation,
                        Location toLocation, Date startDate, Date endDate, Pageable pageable);

}
