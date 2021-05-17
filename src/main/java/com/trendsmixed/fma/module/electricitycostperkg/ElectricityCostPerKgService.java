package com.trendsmixed.fma.module.electricitycostperkg;

import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ElectricityCostPerKgService {

    private ElectricityCostPerKgRepository repository;

    public Iterable<ElectricityCostPerKg> findAll() {
        return repository.findAll();
    }

    public Page<ElectricityCostPerKg> findAll(Pageable pageable) {
        return new Page<>(repository.findAll(pageable));
    }

    public ElectricityCostPerKg save(ElectricityCostPerKg electricityCostPerKg) {
        return repository.save(electricityCostPerKg);
    }

    public void save(List<ElectricityCostPerKg> electricityCostPerKgs) {
        repository.saveAll(electricityCostPerKgs);
    }

    public ElectricityCostPerKg findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

}
