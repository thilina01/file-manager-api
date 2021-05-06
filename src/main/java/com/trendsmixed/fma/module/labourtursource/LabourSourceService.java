package com.trendsmixed.fma.module.labourtursource;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class LabourSourceService {

    private LabourSourceRepository repository;

    public Iterable<LabourSource> findAll() {
        return repository.findAll();
    }

    public Page<LabourSource> findAll(Pageable pageable) {
        return new Page<>(repository.findAll(pageable));
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public LabourSource save(LabourSource labourSource) {
        return repository.save(labourSource);
    }

    public void save(List<LabourSource> labourSources) {
        repository.saveAll(labourSources);
    }

    public LabourSource findById(int id) {
        return repository.findById(id).get();
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public LabourSource findByCode(String code) {
        return repository.findByCode(code);
    }

    public LabourSource findByName(String name) {
        return repository.findByName(name);
    }
}
