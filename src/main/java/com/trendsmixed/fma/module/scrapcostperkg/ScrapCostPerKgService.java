package com.trendsmixed.fma.module.scrapcostperkg;

import com.trendsmixed.fma.entity.ScrapCostPerKg;
import com.trendsmixed.fma.utility.Page;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ScrapCostPerKgService {

    @Autowired
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

    public void save(List<ScrapCostPerKg> countries) {
        repository.save(countries);
    }

    public ScrapCostPerKg findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

}
