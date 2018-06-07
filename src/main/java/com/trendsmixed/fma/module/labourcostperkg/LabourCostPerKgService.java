package com.trendsmixed.fma.module.labourcostperkg;

import com.trendsmixed.fma.utility.Page;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
        repository.save(labourCostPerKgs);
    }

    public LabourCostPerKg findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

}
