package com.trendsmixed.fma.module.sectiontype;

import com.trendsmixed.fma.dao.Combo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SectionTypeService {

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

    public void save(List<SectionType> sectionTypes) {
        repository.saveAll(sectionTypes);
    }

    public SectionType findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public SectionType findByCode(String code) {
        return repository.findByCode(code);
    }

    public SectionType findByName(String name) {
        return repository.findByName(name);
    }
}
