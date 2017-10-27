package com.trendsmixed.fma.module.computer;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
        repository.save(computers);
    }

    public Computer findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public Computer findByCode(String code) {
        return repository.findByCode(code);
    }
}
