package com.trendsmixed.fma.module.toolbreakdown;

import java.util.Date;

import com.trendsmixed.fma.module.tool.Tool;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;

@AllArgsConstructor
@Service
public class ToolBreakdownService {

    private ToolBreakdownRepository repository;

    public Iterable<ToolBreakdown> findAll() {
        return repository.findAll();
    }

    public Page<ToolBreakdown> findAll(Pageable pageable) {
        return repository.findAll(pageable);
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

    public Page<ToolBreakdown>findByToolBreakdownTimeBetween(Date startDate, Date endDate, Pageable pageable) {
        return repository.findByToolBreakdownTimeBetween(startDate, endDate, pageable);
    }

    public Page<ToolBreakdown> findByToolAndToolBreakdownTimeBetween(Tool tool,Date startDate, Date endDate,  Pageable pageable) {
        return repository.findByToolAndToolBreakdownTimeBetween(tool,startDate, endDate,  pageable);
    }


}
