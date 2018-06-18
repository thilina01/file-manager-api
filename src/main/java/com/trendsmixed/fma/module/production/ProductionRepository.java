package com.trendsmixed.fma.module.production;

import com.trendsmixed.fma.module.controlpoint.ControlPoint;
import com.trendsmixed.fma.module.controlpointtype.ControlPointType;
import com.trendsmixed.fma.module.section.Section;
import com.trendsmixed.fma.module.shift.Shift;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;

public interface ProductionRepository extends PagingAndSortingRepository<Production, Integer> {

        Production findByProductionDateAndShiftAndControlPoint(Date productionDate, Shift shift,
                        ControlPoint controlPoint);

        Page<Production> findByControlPointWorkCenterCostCenterSectionAndProductionDateAndShift(Section section,
                        Date date, Shift shift, Pageable pageable);

        Page<Production> findByControlPointWorkCenterCostCenterSectionAndProductionDateBetweenAndShift(Section section,
                        Date startDate, Date endDate, Shift shift, Pageable pageable);

        Page<Production> findByControlPointWorkCenterCostCenterSectionAndProductionDateBetween(Section section,
                        Date startDate, Date endDate, Pageable pageable);

        Page<Production> findByProductionDateAndShift(Date date, Shift shift, Pageable pageable);

        Page<Production> findByProductionDateBetweenAndShift(Date startDate, Date endDate, Shift shift,
                        Pageable pageable);

        Page<Production> findByProductionDateBetween(Date startDate, Date endDate, Pageable pageable);

        Page<Production> findByControlPointWorkCenterCostCenterSectionAndShiftAndProductionDateAndControlPointControlPointType(
                        Section section, Date date, ControlPointType controlPointType, Shift shift, Pageable pageable);

        Page<Production> findByControlPointWorkCenterCostCenterSectionAndShiftAndProductionDateBetweenAndControlPointControlPointType(
                        Section section, Shift shift, Date startDate, Date endDate, ControlPointType controlPointType,
                        Pageable pageable);

        Page<Production> findByProductionDateAndControlPointControlPointType(Date date,
                        ControlPointType controlPointType, Pageable pageable);

        Page<Production> findByProductionDateBetweenAndControlPointControlPointType(Date startDate, Date endDate,
                        ControlPointType controlPointType, Pageable pageable);

        Page<Production> findByControlPointControlPointTypeAndProductionDateAndShift(ControlPointType controlPointType,
                        Date date, Shift shift, Pageable pageable);

        Page<Production> findByControlPointControlPointTypeAndProductionDateBetweenAndShift(
                        ControlPointType controlPointType, Date startDate, Date endDate, Shift shift,
                        Pageable pageable);

        Page<Production> findByControlPointControlPointTypeAndProductionDateAndControlPointWorkCenterCostCenterSection(
                        ControlPointType controlPointType, Date date, Section section, Pageable pageable);

        Page<Production> findByControlPointControlPointTypeAndProductionDateBetweenAndControlPointWorkCenterCostCenterSection(
                        ControlPointType controlPointType, Date startDate, Date endDate, Section section,
                        Pageable pageable);

}
