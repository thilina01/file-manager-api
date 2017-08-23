package com.trendsmixed.fma.module.sectiontype;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SectionTypeService {

    @Autowired
    private SectionTypeRepository repository;

    public Iterable<SectionType> findAll() {
        return repository.findAll();
    }

    public Page<SectionType> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public SectionType save(SectionType sectionType) {
        return repository.save(sectionType);
    }

    public void save(List<SectionType> countries) {
        repository.save(countries);
    }

    public SectionType findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public SectionType findByCode(String code) {
        return repository.findByCode(code);
    }

}
