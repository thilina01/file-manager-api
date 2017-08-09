package com.trendsmixed.fma.module.leavetype;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

@Service
public class LeaveTypeService {

    @Autowired
    private LeaveTypeRepository repository;

    public Iterable<LeaveType> findAll() {
        return repository.findAll();
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public Page<LeaveType> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public LeaveType save(LeaveType leaveType) {
        return repository.save(leaveType);
    }

    public LeaveType findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public LeaveType findByCode(String code) {
        return repository.findByCode(code);
    }
}
