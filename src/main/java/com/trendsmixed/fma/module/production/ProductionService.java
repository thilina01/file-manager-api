package com.trendsmixed.fma.module.production;

import com.trendsmixed.fma.module.controlpoint.ControlPoint;
import com.trendsmixed.fma.module.controlpointtype.ControlPointType;
import com.trendsmixed.fma.module.section.Section;
import com.trendsmixed.fma.module.shift.Shift;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
        repository.saveAll(productions);
    }

    public Production findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public Production findByProductionDateAndShiftAndControlPoint(Date productionDate, Shift shift, ControlPoint controlPoint) {
        return repository.findByProductionDateAndShiftAndControlPoint(productionDate, shift, controlPoint);
    }

    public Page<Production> findByControlPointWorkCenterCostCenterSectionAndProductionDateBetweenAndShift(Section section, Date startDate, Date endDate, Shift shift, Pageable pageable) {
        return repository.findByControlPointWorkCenterCostCenterSectionAndProductionDateBetweenAndShift(section, startDate, endDate, shift, pageable);
    }

    public Page<Production> findByControlPointWorkCenterCostCenterSectionAndProductionDateBetween(Section section, Date startDate, Date endDate, Pageable pageable) {
        return repository.findByControlPointWorkCenterCostCenterSectionAndProductionDateBetween(section, startDate, endDate, pageable);
    }

    public Page<Production> findByProductionDateBetweenAndShift(Date startDate, Date endDate, Shift shift, Pageable pageable) {
        return repository.findByProductionDateBetweenAndShift(startDate, endDate, shift, pageable);
    }

    public Page<Production> findByProductionDateBetween(Date startDate, Date endDate, Pageable pageable) {
        return repository.findByProductionDateBetween(startDate, endDate, pageable);
    }
    
    public Page<Production> findByControlPointWorkCenterCostCenterSectionAndShiftAndProductionDateBetweenAndControlPointControlPointType(Section section,Shift shift, Date startDate, Date endDate,  ControlPointType controlPointType, Pageable pageable) {
        return repository.findByControlPointWorkCenterCostCenterSectionAndShiftAndProductionDateBetweenAndControlPointControlPointType(section, shift, startDate, endDate, controlPointType, pageable);
    }

    public Page<Production> findByProductionDateBetweenAndControlPointControlPointType(Date startDate, Date endDate, ControlPointType controlPointType, Pageable pageable) {
        return repository.findByProductionDateBetweenAndControlPointControlPointType(startDate, endDate, controlPointType, pageable);
    }

    public Page<Production> findByControlPointControlPointTypeAndProductionDateBetweenAndShift(ControlPointType controlPointType, Date startDate, Date endDate, Shift shift, Pageable pageable) {
        return repository.findByControlPointControlPointTypeAndProductionDateBetweenAndShift(controlPointType, startDate, endDate, shift, pageable);
    } 

    public Page<Production> findByControlPointControlPointTypeAndProductionDateBetweenAndControlPointWorkCenterCostCenterSection(ControlPointType controlPointType, Date startDate, Date endDate, Section section, Pageable pageable) {
        return repository.findByControlPointControlPointTypeAndProductionDateBetweenAndControlPointWorkCenterCostCenterSection(controlPointType, startDate, endDate, section, pageable);
    } 

}
