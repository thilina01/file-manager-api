package com.trendsmixed.fma.module.leavetype;

import com.trendsmixed.fma.dao.Combo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class LeaveTypeService {

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

    public LeaveType findById(int id) {
        return repository.findById(id).get();
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public LeaveType findByCode(String code) {
        return repository.findByCode(code);
    }
}
