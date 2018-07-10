package com.trendsmixed.fma.module.internaltransfernote;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.location.Location;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;


@AllArgsConstructor
@Service
public class InternalTransferNoteService {

    private InternalTransferNoteRepository repository;

    public Iterable<InternalTransferNote> findAll() {
        return repository.findAll();
    }

    public Page<InternalTransferNote> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public InternalTransferNote save(InternalTransferNote internalTransferNote) {
        return repository.save(internalTransferNote);
    }

    public void save(List<InternalTransferNote> internalTransferNoteList) {
        repository.save(internalTransferNoteList);
    }

    public InternalTransferNote findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public Page<InternalTransferNote>findByArrivalTimeBetween(Date startDate, Date endDate, Pageable pageable) {
        return repository.findByArrivalTimeBetween(startDate, endDate, pageable);
    }

    public Page<InternalTransferNote>findByReleaseTimeBetween(Date startDate, Date endDate, Pageable pageable) {
        return repository.findByReleaseTimeBetween(startDate, endDate, pageable);
    }

    public Page<InternalTransferNote>findByNoteDateBetween(Date startDate, Date endDate, Pageable pageable) {
        return repository.findByNoteDateBetween(startDate, endDate, pageable);
    }

    public Page<InternalTransferNote> findByToLocationAndNoteDateBetween(Location toLocation, Date startDate, Date endDate, Pageable pageable) {
        return repository.findByToLocationAndNoteDateBetween(toLocation, startDate, endDate, pageable);
    }

    public Page<InternalTransferNote> findByFromLocationAndNoteDateBetween(Location fromLocation, Date startDate, Date endDate, Pageable pageable) {
        return repository.findByFromLocationAndNoteDateBetween(fromLocation, startDate, endDate, pageable);
    }

    public Page<InternalTransferNote> findByFromLocationAndToLocationAndNoteDateBetween(Location fromLocation,Location toLocation, Date startDate, Date endDate, Pageable pageable) {
        return repository.findByFromLocationAndToLocationAndNoteDateBetween(fromLocation,toLocation, startDate, endDate, pageable);
    }


}
