package com.trendsmixed.fma.module.production;

import java.util.Date;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.trendsmixed.fma.module.controlpoint.ControlPoint;
import com.trendsmixed.fma.module.section.Section;
import com.trendsmixed.fma.module.shift.Shift;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductionRepository extends PagingAndSortingRepository<Production, Integer> {

    Production findByProductionDateAndShiftAndControlPoint(Date productionDate, Shift shift, ControlPoint controlPoint);

    public Page<Production> findByControlPointWorkCenterCostCenterSectionAndProductionDateAndShift(Section section, Date date, Shift shift, Pageable pageable);

    public Page<Production> findByControlPointWorkCenterCostCenterSectionAndProductionDateBetweenAndShift(Section section, Date startDate, Date endDate, Shift shift, Pageable pageable);

    public Page<Production> findByControlPointWorkCenterCostCenterSectionAndProductionDateBetween(Section section, Date startDate, Date endDate, Pageable pageable);

    public Page<Production> findByProductionDateAndShift(Date date, Shift shift, Pageable pageable);

    public Page<Production> findByProductionDateBetweenAndShift(Date startDate, Date endDate, Shift shift, Pageable pageable);

    public Page<Production> findByProductionDateBetween(Date startDate, Date endDate, Pageable pageable);

}
