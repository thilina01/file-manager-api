package com.trendsmixed.fma.module.internaltransferitem;

import com.trendsmixed.fma.dao.Combo;

import java.util.List;
import java.util.Date;

import com.trendsmixed.fma.module.location.Location;
import com.trendsmixed.fma.module.job.Job;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;


@AllArgsConstructor
@Service
public class InternalTransferItemService {

    private InternalTransferItemRepository repository;

    public Iterable<InternalTransferItem> findAll() {
        return repository.findAll();
    }

    public Page<InternalTransferItem> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public InternalTransferItem save(InternalTransferItem internalTransferItem) {
        return repository.save(internalTransferItem);
    }

    public void save(List<InternalTransferItem> internalTransferItemList) {
        repository.save(internalTransferItemList);
    }

    public Page<InternalTransferItem>findByInternalTransferNoteNoteDateBetween(Date startDate, Date endDate, Pageable pageable) {
        return repository.findByInternalTransferNoteNoteDateBetween(startDate, endDate, pageable);
    }

    public Page<InternalTransferItem> findByInternalTransferNoteToLocationAndInternalTransferNoteNoteDateBetween(Location toLocation, Date startDate, Date endDate, Pageable pageable) {
        return repository.findByInternalTransferNoteToLocationAndInternalTransferNoteNoteDateBetween(toLocation, startDate, endDate, pageable);
    }

    public Page<InternalTransferItem> findByInternalTransferNoteFromLocationAndInternalTransferNoteNoteDateBetween(Location fromLocation, Date startDate, Date endDate, Pageable pageable) {
        return repository.findByInternalTransferNoteFromLocationAndInternalTransferNoteNoteDateBetween(fromLocation, startDate, endDate, pageable);
    }

    public Page<InternalTransferItem> findByJobAndInternalTransferNoteNoteDateBetween(Job job, Date startDate, Date endDate, Pageable pageable) {
        return repository.findByJobAndInternalTransferNoteNoteDateBetween(job, startDate, endDate, pageable);
    }

    public Page<InternalTransferItem> findByInternalTransferNoteToLocationAndInternalTransferNoteFromLocationAndInternalTransferNoteNoteDateBetween(Location toLocation,Location fromLocation, Date startDate, Date endDate, Pageable pageable) {
        return repository.findByInternalTransferNoteToLocationAndInternalTransferNoteFromLocationAndInternalTransferNoteNoteDateBetween(toLocation,fromLocation,startDate, endDate, pageable);
    }

    public Page<InternalTransferItem> findByInternalTransferNoteFromLocationAndJobAndInternalTransferNoteNoteDateBetween(Location fromLocation,Job job, Date startDate, Date endDate, Pageable pageable) {
        return repository.findByInternalTransferNoteFromLocationAndJobAndInternalTransferNoteNoteDateBetween(fromLocation,job,startDate, endDate, pageable);
    }

    public Page<InternalTransferItem> findByInternalTransferNoteToLocationAndJobAndInternalTransferNoteNoteDateBetween(Location toLocation,Job job, Date startDate, Date endDate, Pageable pageable) {
        return repository.findByInternalTransferNoteToLocationAndJobAndInternalTransferNoteNoteDateBetween(toLocation,job,startDate, endDate, pageable);
    }

    public Page<InternalTransferItem> findByInternalTransferNoteFromLocationAndInternalTransferNoteToLocationAndJobAndInternalTransferNoteNoteDateBetween(Location fromLocation,Location toLocation,Job job, Date startDate, Date endDate, Pageable pageable) {
        return repository.findByInternalTransferNoteFromLocationAndInternalTransferNoteToLocationAndJobAndInternalTransferNoteNoteDateBetween(fromLocation,toLocation,job, startDate, endDate, pageable);
    }

    public InternalTransferItem findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

}
