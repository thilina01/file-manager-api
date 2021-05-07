package com.trendsmixed.fma.module.shiftroster;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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
        repository.saveAll(shifts);
    }

    public ShiftRoster findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public ShiftRoster findByName(String name) {
        return repository.findByName(name);
    }
}
