package com.trendsmixed.fma.module.toolbreakdown;

import com.trendsmixed.fma.entity.ToolBreakdown;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToolBreakdownService {

    @Autowired
    private ToolBreakdownRepository toolBreakdownRepository;

    public List<ToolBreakdown> findAll() {
        return toolBreakdownRepository.findAll();
    }

    public ToolBreakdown save(ToolBreakdown toolBreakdown) {
        return toolBreakdownRepository.save(toolBreakdown);
    }

    public ToolBreakdown findOne(int id) {
        return toolBreakdownRepository.findOne(id);
    }

    public void delete(int id) {
        toolBreakdownRepository.delete(id);
    }
}
