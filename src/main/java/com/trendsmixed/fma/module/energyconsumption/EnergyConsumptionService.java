package com.trendsmixed.fma.module.energyconsumption;

import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class EnergyConsumptionService {

    private EnergyConsumptionRepository repository;

    public Iterable<EnergyConsumption> findAll() {
        return repository.findAll();
    }

    public Page<EnergyConsumption> findAll(Pageable pageable) {
        return new Page<>(repository.findAll(pageable));
    }

    public EnergyConsumption save(EnergyConsumption energyConsumption) {
        return repository.save(energyConsumption);
    }

    public void save(List<EnergyConsumption> energyConsumptions) {
        repository.save(energyConsumptions);
    }

    public EnergyConsumption findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

}
