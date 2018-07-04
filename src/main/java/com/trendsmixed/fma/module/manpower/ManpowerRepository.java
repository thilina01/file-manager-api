package com.trendsmixed.fma.module.manpower;

import com.trendsmixed.fma.module.controlpoint.ControlPoint;
import com.trendsmixed.fma.module.manpowertype.ManpowerType;
import com.trendsmixed.fma.module.production.Production;
import com.trendsmixed.fma.module.shift.Shift;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface ManpowerRepository extends PagingAndSortingRepository<Manpower, Integer> {

    List<Manpower> findByProduction(Production production);

    Page<Manpower> findByProductionProductionDateBetween(Date startDate, Date endDate, Pageable pageable);

    Page<Manpower> findByProductionControlPointAndProductionProductionDateBetween(ControlPoint controlPoint,
            Date startDate, Date endDate, Pageable pageable);

    Page<Manpower> findByManpowerTypeAndProductionProductionDateBetween(ManpowerType manpowerType, Date startDate,
            Date endDate, Pageable pageable);

    Page<Manpower> findByManpowerTypeAndProductionControlPointAndProductionProductionDateBetween(
            ManpowerType manpowerType, ControlPoint controlPoint, Date startDate, Date endDate, Pageable pageable);

    Page<Manpower> findByProductionShiftAndProductionProductionDateBetween(Shift shift, Date startDate, Date endDate,
            Pageable pageable);

    Page<Manpower> findByManpowerTypeAndProductionShiftAndProductionProductionDateBetween(ManpowerType manpowerType,
            Shift shift, Date startDate, Date endDate, Pageable pageable);

    Page<Manpower> findByProductionControlPointAndProductionShiftAndProductionProductionDateBetween(
            ControlPoint controlPoint, Shift shift, Date startDate, Date endDate, Pageable pageable);

    Page<Manpower> findByManpowerTypeAndProductionControlPointAndProductionShiftAndProductionProductionDateBetween(
            ManpowerType manpowerType, ControlPoint controlPoint, Shift shift, Date startDate, Date endDate,
            Pageable pageable);

}
