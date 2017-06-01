package com.trendsmixed.fma.module.labourtursource;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.entity.LabourSource;
import com.trendsmixed.fma.utility.Page;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LabourSourceService {

    @Autowired
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
        repository.save(labourSources);
    }

    public LabourSource findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public LabourSource findByCode(String code) {
        return repository.findByCode(code);
    }

    public LabourSource findByName(String name) {
        return repository.findByName(name);
    }
}
