package com.trendsmixed.fma.module.subcontractarrivalreject;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.job.Job;
import com.trendsmixed.fma.module.subcontractor.Subcontractor;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;


@AllArgsConstructor
@Service
public class SubcontractArrivalRejectService {

    private SubcontractArrivalRejectRepository repository;

    public Iterable<SubcontractArrivalReject> findAll() {
        return repository.findAll();
    }

    public Page<SubcontractArrivalReject> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public SubcontractArrivalReject save(SubcontractArrivalReject subcontractArrivalReject) {
        return repository.save(subcontractArrivalReject);
    }

    public void save(List<SubcontractArrivalReject> subcontractArrivalRejectList) {
        repository.save(subcontractArrivalRejectList);
    }

    public SubcontractArrivalReject findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public Iterable<SubcontractArrivalReject> findBySubcontractArrivalSubcontractOperationSubcontractOperationRateSubcontractorOperationSubcontractor(Subcontractor subcontractor) {
        return repository.findBySubcontractArrivalSubcontractOperationSubcontractOperationRateSubcontractorOperationSubcontractor(subcontractor);
    }
   
    public Page<SubcontractArrivalReject>findByArrivalRejectDateBetween(Date startDate, Date endDate, Pageable pageable) {
        return repository.findByArrivalRejectDateBetween(startDate, endDate, pageable);

    }
    public Page<SubcontractArrivalReject> findBySubcontractArrivalSubcontractOperationSubcontractOperationRateSubcontractorOperationSubcontractorAndArrivalRejectDateBetween(Subcontractor subcontractor, Date startDate, Date endDate, Pageable pageable) {
        return repository.findBySubcontractArrivalSubcontractOperationSubcontractOperationRateSubcontractorOperationSubcontractorAndArrivalRejectDateBetween(subcontractor, startDate, endDate, pageable);
    }

    public Page<SubcontractArrivalReject> findBySubcontractArrivalSubcontractOperationJobAndArrivalRejectDateBetween(Job job, Date startDate, Date endDate, Pageable pageable) {
        return repository.findBySubcontractArrivalSubcontractOperationJobAndArrivalRejectDateBetween(job, startDate, endDate, pageable);
    }

    public Page<SubcontractArrivalReject> findBySubcontractArrivalSubcontractOperationSubcontractOperationRateSubcontractorOperationSubcontractorAndSubcontractArrivalSubcontractOperationJobAndArrivalRejectDateBetween(Subcontractor subcontractor,Job job, Date startDate, Date endDate, Pageable pageable) {
        return repository.findBySubcontractArrivalSubcontractOperationSubcontractOperationRateSubcontractorOperationSubcontractorAndSubcontractArrivalSubcontractOperationJobAndArrivalRejectDateBetween(subcontractor,job, startDate, endDate, pageable);
    }
   
}
