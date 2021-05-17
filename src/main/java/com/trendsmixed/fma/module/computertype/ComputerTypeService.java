package com.trendsmixed.fma.module.computertype;

import com.trendsmixed.fma.dao.Combo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ComputerTypeService {

    private ComputerTypeRepository repository;

    public Iterable<ComputerType> findAll() {
        return repository.findAll();
    }

    public Page<ComputerType> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public ComputerType save(ComputerType computerType) {
        return repository.save(computerType);
    }

    public void save(List<ComputerType> computerTypes) {
        repository.saveAll(computerTypes);
    }

    public ComputerType findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public ComputerType findByName(String name) {
        return repository.findByName(name);
    }
}
