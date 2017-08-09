package com.trendsmixed.fma.module.electricitycostperkg;

import com.trendsmixed.fma.utility.Page;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ElectricityCostPerKgService {

    @Autowired
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

    public void save(List<ElectricityCostPerKg> countries) {
        repository.save(countries);
    }

    public ElectricityCostPerKg findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

}
