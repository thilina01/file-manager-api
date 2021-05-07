package com.trendsmixed.fma.module.shifttype;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ShiftTypeService {

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
        repository.saveAll(shifts);
    }

    public ShiftType findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public ShiftType findByName(String name) {
        return repository.findByName(name);
    }

    public ShiftType findByCode(String code) {
        return repository.findByCode(code);
    }
}
