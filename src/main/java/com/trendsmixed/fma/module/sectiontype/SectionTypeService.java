package com.trendsmixed.fma.module.sectiontype;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SectionTypeService {

    @Autowired
    private SectionTypeRepository repository;

    public List<SectionType> findAll() {
        return repository.findAll();
    }

    public SectionType save(SectionType sectionType) {
        return repository.save(sectionType);
    }

    public void save(List<SectionType> sectionTypes) {
        repository.save(sectionTypes);
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
