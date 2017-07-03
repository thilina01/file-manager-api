package com.trendsmixed.fma.module.shifttype;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.entity.ShiftType;
import com.trendsmixed.fma.utility.Page;

@Service
public class ShiftTypeService {

    @Autowired
    private ShiftTypeRepository repository;

    public Iterable<ShiftType> findAll() {
        return repository.findAll();
    }

    public Page<ShiftType> findAll(Pageable pageable) {
        return new Page<>(repository.findAll(pageable));
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public ShiftType save(ShiftType shiftType) {
        return repository.save(shiftType);
    }

    public void save(List<ShiftType> shifts) {
        repository.save(shifts);
    }

    public ShiftType findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public ShiftType findByName(String name) {
        return repository.findByName(name);
    }
}
