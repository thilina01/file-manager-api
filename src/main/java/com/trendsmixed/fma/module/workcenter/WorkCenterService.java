package com.trendsmixed.fma.module.workcenter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.entity.WorkCenter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class WorkCenterService {

    @Autowired
    private WorkCenterRepository repository;

    public Iterable<WorkCenter> findAll() {
        return repository.findAll();
    }

    public Page<WorkCenter> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public WorkCenter save(WorkCenter workCenter) {
        return repository.save(workCenter);
    }

    public void save(List<WorkCenter> workCenters) {
        repository.save(workCenters);
    }

    public WorkCenter findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public WorkCenter findByCode(String code) {
        return repository.findByCode(code);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }
}
