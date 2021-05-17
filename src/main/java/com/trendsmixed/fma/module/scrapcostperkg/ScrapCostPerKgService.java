package com.trendsmixed.fma.module.scrapcostperkg;

import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ScrapCostPerKgService {

    private ScrapCostPerKgRepository repository;

    public Iterable<ScrapCostPerKg> findAll() {
        return repository.findAll();
    }

    public Page<ScrapCostPerKg> findAll(Pageable pageable) {
        return new Page<>(repository.findAll(pageable));
    }

    public ScrapCostPerKg save(ScrapCostPerKg scrapCostPerKg) {
        return repository.save(scrapCostPerKg);
    }

    public void save(List<ScrapCostPerKg> scrapCostPerKgs) {
        repository.saveAll(scrapCostPerKgs);
    }

    public ScrapCostPerKg findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

}
