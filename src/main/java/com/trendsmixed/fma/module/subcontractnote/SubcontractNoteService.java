package com.trendsmixed.fma.module.subcontractnote;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.location.Location;
import com.trendsmixed.fma.module.subcontractor.Subcontractor;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;


@AllArgsConstructor
@Service
public class SubcontractNoteService {

    private SubcontractNoteRepository repository;

    public Iterable<SubcontractNote> findAll() {
        return repository.findAll();
    }

    public Page<SubcontractNote> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public SubcontractNote save(SubcontractNote subcontractNote) {
        return repository.save(subcontractNote);
    }

    public void save(List<SubcontractNote> subcontractNoteList) {
        repository.save(subcontractNoteList);
    }

    public SubcontractNote findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public Page<SubcontractNote>findByNoteTimeBetween(Date startDate, Date endDate, Pageable pageable) {
        return repository.findByNoteTimeBetween(startDate, endDate, pageable);

    }
    
    public Page<SubcontractNote> findBySubcontractorAndNoteTimeBetween(Subcontractor subcontractor, Date startDate, Date endDate, Pageable pageable) {
        return repository.findBySubcontractorAndNoteTimeBetween(subcontractor, startDate, endDate, pageable);
    }
    
    public Page<SubcontractNote> findBySubcontractorAndSubcontractReleaseTimeBetween(Subcontractor subcontractor, Date startDate, Date endDate, Pageable pageable) {
        return repository.findBySubcontractorAndSubcontractReleaseTimeBetween(subcontractor, startDate, endDate, pageable);
    }

    public Page<SubcontractNote>findBySubcontractReleaseTimeBetween(Date startDate, Date endDate, Pageable pageable) {
        return repository.findBySubcontractReleaseTimeBetween(startDate, endDate, pageable);

    }

    public Page<SubcontractNote> findByLocationAndSubcontractReleaseTimeBetween(Location location, Date startDate, Date endDate, Pageable pageable) {
        return repository.findByLocationAndSubcontractReleaseTimeBetween(location, startDate, endDate, pageable);
    }

    public Page<SubcontractNote> findByLocationAndSubcontractorAndSubcontractReleaseTimeBetween(Location location,Subcontractor subcontractor, Date startDate, Date endDate, Pageable pageable) {
        return repository.findByLocationAndSubcontractorAndSubcontractReleaseTimeBetween(location,subcontractor, startDate, endDate, pageable);
    }
}
