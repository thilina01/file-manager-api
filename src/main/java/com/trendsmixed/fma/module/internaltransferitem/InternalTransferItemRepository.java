package com.trendsmixed.fma.module.internaltransferitem;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.trendsmixed.fma.dao.Combo;

import com.trendsmixed.fma.module.location.Location;
import com.trendsmixed.fma.module.job.Job;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Date;

public interface InternalTransferItemRepository extends PagingAndSortingRepository<InternalTransferItem, Integer> {

        @Query(value = "SELECT" + " new com.trendsmixed.fma.dao.Combo(o.id,CONCAT(o.id,''),'')"
                        + " FROM InternalTransferItem o")
        List<Combo> getCombo();

        Page<InternalTransferItem> findByInternalTransferNoteNoteDateBetween(Date startDate, Date endDate, Pageable pageable);

        Page<InternalTransferItem> findByInternalTransferNoteToLocationAndInternalTransferNoteNoteDateBetween(Location toLocation, Date startDate, Date endDate,
                        Pageable pageable);

        Page<InternalTransferItem> findByInternalTransferNoteFromLocationAndInternalTransferNoteNoteDateBetween(Location fromLocation, Date startDate,
                        Date endDate, Pageable pageable);

        Page<InternalTransferItem> findByJobAndInternalTransferNoteNoteDateBetween(Job job, Date startDate,
                        Date endDate, Pageable pageable); 
                        
        Page<InternalTransferItem> findByInternalTransferNoteToLocationAndInternalTransferNoteFromLocationAndInternalTransferNoteNoteDateBetween(Location toLocation,Location fromLocation, Date startDate,
                        Date endDate, Pageable pageable); 
                        
        Page<InternalTransferItem> findByInternalTransferNoteFromLocationAndJobAndInternalTransferNoteNoteDateBetween(Location fromLocation,Job job, Date startDate,
                        Date endDate, Pageable pageable); 

        Page<InternalTransferItem> findByInternalTransferNoteToLocationAndJobAndInternalTransferNoteNoteDateBetween(Location toLocation,Job job, Date startDate,
                        Date endDate, Pageable pageable); 

        Page<InternalTransferItem> findByInternalTransferNoteFromLocationAndInternalTransferNoteToLocationAndJobAndInternalTransferNoteNoteDateBetween(Location fromLocation,
                        Location toLocation,Job job, Date startDate, Date endDate, Pageable pageable);

}
