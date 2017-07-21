package com.trendsmixed.fma.module.manpowertype;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.entity.ManpowerType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class ManpowerTypeService {

    @Autowired
    private ManpowerTypeRepository repository;

    public Iterable<ManpowerType> findAll() {
        return repository.findAll();
    }

    public Page<ManpowerType> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public ManpowerType save(ManpowerType manpowerType) {
        return repository.save(manpowerType);
    }

    public ManpowerType findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public ManpowerType findByCode(String code) {
        return repository.findByCode(code);
    }

    public ManpowerType findByName(String name) {
        return repository.findByName(name);
    }
}
