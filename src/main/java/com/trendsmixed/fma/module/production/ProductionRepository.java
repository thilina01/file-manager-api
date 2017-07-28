package com.trendsmixed.fma.module.production;

import java.util.Date;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.trendsmixed.fma.module.controlpoint.ControlPoint;
import com.trendsmixed.fma.module.shift.Shift;

public interface ProductionRepository extends PagingAndSortingRepository<Production, Integer> {

    Production findByProductionDateAndShiftAndControlPoint(Date productionDate, Shift shift, ControlPoint controlPoint);
}
