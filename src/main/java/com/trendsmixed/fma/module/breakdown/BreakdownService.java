package com.trendsmixed.fma.module.breakdown;
import org.springframework.data.domain.Page;
import lombok.AllArgsConstructor;
import java.util.Date;
import com.trendsmixed.fma.module.machine.Machine;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

    public Breakdown findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }
    
    public Page<Breakdown> findByBreakdownTimeBetween(Date startDate, Date endDate, Pageable pageable) {
        return repository.findByBreakdownTimeBetween(startDate, endDate, pageable);
    }
    public Page<Breakdown> findByBreakdownTimeBetweenAndMachine(Date startDate, Date endDate, Machine machine, Pageable pageable) {
        return repository.findByBreakdownTimeBetweenAndMachine(startDate, endDate, machine, pageable);
    }
    public Page<Breakdown> findByBreakdownTimeAndMachine(Date date, Machine machine, Pageable pageable) {
        return repository.findByBreakdownTimeAndMachine(date, machine, pageable);
    }
    Page<Breakdown> findByMachine(Machine machine, Pageable pageable) {
        return repository.findByMachine(machine, pageable);
    }
}
