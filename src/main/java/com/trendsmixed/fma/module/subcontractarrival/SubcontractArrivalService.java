package com.trendsmixed.fma.module.subcontractarrival;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.job.Job;
import com.trendsmixed.fma.module.subcontractnote.SubcontractNote;
import com.trendsmixed.fma.module.subcontractor.Subcontractor;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;


@AllArgsConstructor
@Service
public class SubcontractArrivalService {

    private SubcontractArrivalRepository repository;

    public Iterable<SubcontractArrival> findAll() {
        return repository.findAll();
    }

    public Page<SubcontractArrival> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public SubcontractArrival save(SubcontractArrival subcontractArrival) {
        return repository.save(subcontractArrival);
    }

    public void save(List<SubcontractArrival> subcontractArrivalList) {
        repository.saveAll(subcontractArrivalList);
    }

    public SubcontractArrival findById(int id) {
        return repository.findById(id).get();
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
    
    public Iterable<SubcontractArrival> findBySubcontractOperationSubcontractNote(SubcontractNote subcontractNote) {
        return repository.findBySubcontractOperationSubcontractNote(subcontractNote);
    }
   
    public Page<SubcontractArrival>findByArrivalTimeBetween(Date startDate, Date endDate, Pageable pageable) {
        return repository.findByArrivalTimeBetween(startDate, endDate, pageable);

    }
    
    public Page<SubcontractArrival> findBySubcontractOperationSubcontractOperationRateSubcontractorOperationSubcontractorAndArrivalTimeBetween(Subcontractor subcontractor, Date startDate, Date endDate, Pageable pageable) {
        return repository.findBySubcontractOperationSubcontractOperationRateSubcontractorOperationSubcontractorAndArrivalTimeBetween(subcontractor, startDate, endDate, pageable);
    }

    public Page<SubcontractArrival> findBySubcontractOperationJobAndArrivalTimeBetween(Job job, Date startDate, Date endDate, Pageable pageable) {
        return repository.findBySubcontractOperationJobAndArrivalTimeBetween(job, startDate, endDate, pageable);
    }

    public Page<SubcontractArrival> findBySubcontractOperationSubcontractOperationRateSubcontractorOperationSubcontractorAndSubcontractOperationJobAndArrivalTimeBetween(Subcontractor subcontractor,Job job, Date startDate, Date endDate, Pageable pageable) {
        return repository.findBySubcontractOperationSubcontractOperationRateSubcontractorOperationSubcontractorAndSubcontractOperationJobAndArrivalTimeBetween(subcontractor,job, startDate, endDate, pageable);
    }
}
