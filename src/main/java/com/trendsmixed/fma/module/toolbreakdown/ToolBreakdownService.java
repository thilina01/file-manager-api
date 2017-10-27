package com.trendsmixed.fma.module.toolbreakdown;

import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ToolBreakdownService {

    private ToolBreakdownRepository repository;

    public Iterable<ToolBreakdown> findAll() {
        return repository.findAll();
    }

    public Page<ToolBreakdown> findAll(Pageable pageable) {
        return new Page<>(repository.findAll(pageable));
    }

    public ToolBreakdown save(ToolBreakdown toolBreakdown) {
        return repository.save(toolBreakdown);
    }

    public ToolBreakdown findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }
}
