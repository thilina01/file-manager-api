package com.trendsmixed.fma.module.machine;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class MachineService {

    private MachineRepository repository;

    public Iterable<Machine> findAll() {
        return repository.findAll();
    }

    public Page<Machine> findAll(Pageable pageable) {
        return new Page<Machine>(repository.findAll(pageable));
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public Machine save(Machine machine) {
        return repository.save(machine);
    }

    public void save(List<Machine> machines) {
        repository.saveAll(machines);
    }

    public Machine findById(int id) {
        return repository.findById(id).get();
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public Machine findByCode(String code) {
        return repository.findByCode(code);
    }
}
