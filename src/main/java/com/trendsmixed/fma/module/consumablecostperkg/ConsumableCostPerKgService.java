package com.trendsmixed.fma.module.consumablecostperkg;

import com.trendsmixed.fma.utility.Page;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ConsumableCostPerKgService {

    private ConsumableCostPerKgRepository repository;

    public Iterable<ConsumableCostPerKg> findAll() {
        return repository.findAll();
    }

    public Page<ConsumableCostPerKg> findAll(Pageable pageable) {
        return new Page<>(repository.findAll(pageable));
    }

    public ConsumableCostPerKg save(ConsumableCostPerKg consumableCostPerKg) {
        return repository.save(consumableCostPerKg);
    }

    public void save(List<ConsumableCostPerKg> countries) {
        repository.save(countries);
    }

    public ConsumableCostPerKg findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

}
