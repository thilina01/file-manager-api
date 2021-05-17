package com.trendsmixed.fma.module.subcontractreworknote;

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
public class SubcontractReworkNoteService {

    private SubcontractReworkNoteRepository repository;

    public Iterable<SubcontractReworkNote> findAll() {
        return repository.findAll();
    }

    public Page<SubcontractReworkNote> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public SubcontractReworkNote save(SubcontractReworkNote subcontractReworkNote) {
        return repository.save(subcontractReworkNote);
    }

    public void save(List<SubcontractReworkNote> subcontractReworkNoteList) {
        repository.saveAll(subcontractReworkNoteList);
    }

    public SubcontractReworkNote findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public Page<SubcontractReworkNote>findByNoteTimeBetween(Date startDate, Date endDate, Pageable pageable) {
        return repository.findByNoteTimeBetween(startDate, endDate, pageable);

    }
    
    public Page<SubcontractReworkNote> findBySubcontractorAndNoteTimeBetween(Subcontractor subcontractor, Date startDate, Date endDate, Pageable pageable) {
        return repository.findBySubcontractorAndNoteTimeBetween(subcontractor, startDate, endDate, pageable);
    }

    public Page<SubcontractReworkNote> findBySubcontractorAndSubcontractReleaseTimeBetween(Subcontractor subcontractor, Date startDate, Date endDate, Pageable pageable) {
        return repository.findBySubcontractorAndSubcontractReleaseTimeBetween(subcontractor, startDate, endDate, pageable);
    }

    public Page<SubcontractReworkNote>findBySubcontractReleaseTimeBetween(Date startDate, Date endDate, Pageable pageable) {
        return repository.findBySubcontractReleaseTimeBetween(startDate, endDate, pageable);

    }

    public Page<SubcontractReworkNote> findByLocationAndSubcontractReleaseTimeBetween(Location location, Date startDate, Date endDate, Pageable pageable) {
        return repository.findByLocationAndSubcontractReleaseTimeBetween(location, startDate, endDate, pageable);
    }

    public Page<SubcontractReworkNote> findByLocationAndSubcontractorAndSubcontractReleaseTimeBetween(Location location,Subcontractor subcontractor, Date startDate, Date endDate, Pageable pageable) {
        return repository.findByLocationAndSubcontractorAndSubcontractReleaseTimeBetween(location,subcontractor, startDate, endDate, pageable);
    }

}
