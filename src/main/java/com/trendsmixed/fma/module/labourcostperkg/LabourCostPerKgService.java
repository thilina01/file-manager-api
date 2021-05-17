package com.trendsmixed.fma.module.labourcostperkg;

import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class LabourCostPerKgService {

    private LabourCostPerKgRepository repository;

    public Iterable<LabourCostPerKg> findAll() {
        return repository.findAll();
    }

    public Page<LabourCostPerKg> findAll(Pageable pageable) {
        return new Page<>(repository.findAll(pageable));
    }

    public LabourCostPerKg save(LabourCostPerKg labourCostPerKg) {
        return repository.save(labourCostPerKg);
    }

    public void save(List<LabourCostPerKg> labourCostPerKgs) {
        repository.saveAll(labourCostPerKgs);
    }

    public LabourCostPerKg findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

}
