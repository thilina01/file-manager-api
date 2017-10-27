package com.trendsmixed.fma.module.breakdown;

import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
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
        return new Page<>(repository.findAll(pageable));
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
}
