package com.trendsmixed.fma.module.production;

import com.trendsmixed.fma.module.controlpoint.ControlPoint;
import com.trendsmixed.fma.module.section.Section;
import com.trendsmixed.fma.module.shift.Shift;

import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProductionService {

    private ProductionRepository repository;

    public Iterable<Production> findAll() {
        return repository.findAll();
    }

    public Page<Production> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Production save(Production production) {
        return repository.save(production);
    }

    public void save(List<Production> productions) {
        repository.save(productions);
    }

    public Production findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public Production findByProductionDateAndShiftAndControlPoint(Date productionDate, Shift shift, ControlPoint controlPoint) {
        return repository.findByProductionDateAndShiftAndControlPoint(productionDate, shift, controlPoint);
    }

    public Page<Production> findByControlPointWorkCenterCostCenterSectionAndProductionDateAndShift(Section section, Date date, Shift shift, Pageable pageable) {
        return repository.findByControlPointWorkCenterCostCenterSectionAndProductionDateAndShift(section, date, shift, pageable);

    }

    public Page<Production> findByControlPointWorkCenterCostCenterSectionAndProductionDateBetweenAndShift(Section section, Date startDate, Date endDate, Shift shift, Pageable pageable) {
        return repository.findByControlPointWorkCenterCostCenterSectionAndProductionDateBetweenAndShift(section, startDate, endDate, shift, pageable);
    }

    public Page<Production> findByControlPointWorkCenterCostCenterSectionAndProductionDateBetween(Section section, Date startDate, Date endDate, Pageable pageable) {
        return repository.findByControlPointWorkCenterCostCenterSectionAndProductionDateBetween(section, startDate, endDate, pageable);
    }

    public Page<Production> findByProductionDateAndShift(Date date, Shift shift, Pageable pageable) {
        return repository.findByProductionDateAndShift(date, shift, pageable);
    }

    public Page<Production> findByProductionDateBetweenAndShift(Date startDate, Date endDate, Shift shift, Pageable pageable) {
        return repository.findByProductionDateBetweenAndShift(startDate, endDate, shift, pageable);
    }

    public Page<Production> findByProductionDateBetween(Date startDate, Date endDate, Pageable pageable) {
        return repository.findByProductionDateBetween(startDate, endDate, pageable);

    }

}
