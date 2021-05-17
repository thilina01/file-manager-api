package com.trendsmixed.fma.module.computer;

import com.trendsmixed.fma.dao.Combo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ComputerService {

    private ComputerRepository repository;

    public Iterable<Computer> findAll() {
        return repository.findAll();
    }

    public Page<Computer> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public Computer save(Computer computer) {
        return repository.save(computer);
    }

    public void save(List<Computer> computers) {
        repository.saveAll(computers);
    }

    public Computer findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public Computer findByCode(String code) {
        return repository.findByCode(code);
    }
}
