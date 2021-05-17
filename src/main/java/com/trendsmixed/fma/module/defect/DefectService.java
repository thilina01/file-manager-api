package com.trendsmixed.fma.module.defect;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import com.trendsmixed.fma.module.section.Section;

@AllArgsConstructor
@Service
public class DefectService {

    private DefectRepository repository;

    public Iterable<Defect> findAll() {
        return repository.findAll();
    }

    public Page<Defect> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Defect save(Defect defect) {
        return repository.save(defect);
    }

    public void save(List<Defect> defects) {
        repository.saveAll(defects);
    }

    public Defect findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public Page<Defect>findByDefectDateBetween(Date startDate, Date endDate, Pageable pageable) {
        return repository.findByDefectDateBetween(startDate, endDate, pageable);
    }

    public Page<Defect> findBySectionAndDefectDateBetween(Section section, Date startDate, Date endDate, Pageable pageable) {
        return repository.findBySectionAndDefectDateBetween(section, startDate, endDate, pageable);
    }
}
