package com.trendsmixed.fma.module.shiftroster;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ShiftRosterService {

    private ShiftRosterRepository repository;

    public Iterable<ShiftRoster> findAll() {
        return repository.findAll();
    }

    public Page<ShiftRoster> findAll(Pageable pageable) {
        return new Page<>(repository.findAll(pageable));
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public ShiftRoster save(ShiftRoster shiftRoster) {
        return repository.save(shiftRoster);
    }

    public void save(List<ShiftRoster> shifts) {
        repository.save(shifts);
    }

    public ShiftRoster findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public ShiftRoster findByName(String name) {
        return repository.findByName(name);
    }
}
