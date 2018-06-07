package com.trendsmixed.fma.module.tool;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ToolService {

    private ToolRepository repository;

    public Iterable<Tool> findAll() {
        return repository.findAll();
    }

    public Page<Tool> findAll(Pageable pageable) {
        return new Page<Tool>(repository.findAll(pageable));
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public Tool save(Tool tool) {
        return repository.save(tool);
    }

    public void save(List<Tool> tools) {
        repository.save(tools);
    }

    public Tool findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public Tool findByCode(String code) {
        return repository.findByCode(code);
    }
}
