package com.trendsmixed.fma.module.electricitycostperkg;

import com.trendsmixed.fma.utility.Page;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
        repository.save(electricityCostPerKgs);
    }

    public ElectricityCostPerKg findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

}
