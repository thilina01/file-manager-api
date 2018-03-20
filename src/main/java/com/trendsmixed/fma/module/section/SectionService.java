package com.trendsmixed.fma.module.section;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SectionService {

    private SectionRepository repository;

    public Iterable<Section> findAll() {
        return repository.findAll();
    }

    public Page<Section> findAll(Pageable pageable) {
        return new Page<Section>(repository.findAll(pageable));
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public Section save(Section section) {
        return repository.save(section);
    }

    public void save(List<Section> sections) {
        repository.save(sections);
    }

    public Section findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public Section findByCode(String code) {
        return repository.findByCode(code);
    }

    public Section findByIdAndCostCenterListWorkCenterListControlPointListProductionListProductionDate(int id, Date productionDate) {
        return repository.findByIdAndCostCenterListWorkCenterListControlPointListProductionListProductionDate(id, productionDate);
    }

}
