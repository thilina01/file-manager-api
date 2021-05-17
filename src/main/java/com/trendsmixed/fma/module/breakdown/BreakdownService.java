package com.trendsmixed.fma.module.breakdown;

import com.trendsmixed.fma.module.machine.Machine;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@AllArgsConstructor
@Service
public class BreakdownService {

    private BreakdownRepository repository;

    public Iterable<Breakdown> findAll() {
        return repository.findAll();
    }

    public Page<Breakdown> findAll(Pageable pageable) {
    return repository.findAll(pageable);
    }

    public Breakdown save(Breakdown breakdown) {
        return repository.save(breakdown);
    }

    public Breakdown findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
    
    public Page<Breakdown> findByBreakdownTimeBetween(Date startDate, Date endDate, Pageable pageable) {
        return repository.findByBreakdownTimeBetween(startDate, endDate, pageable);
    }

    public Page<Breakdown> findByBreakdownTimeBetweenAndMachine(Date startDate, Date endDate, Machine machine, Pageable pageable) {
        return repository.findByBreakdownTimeBetweenAndMachine(startDate, endDate, machine, pageable);
    }
    
    Page<Breakdown> findByMachine(Machine machine, Pageable pageable) {
        return repository.findByMachine(machine, pageable);
    }
}
