package com.trendsmixed.fma.module.production;

import java.util.Date;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.trendsmixed.fma.entity.ControlPoint;
import com.trendsmixed.fma.entity.Production;
import com.trendsmixed.fma.entity.Shift;

public interface ProductionRepository extends PagingAndSortingRepository<Production, Integer> {

    Production findByProductionDateAndShiftAndControlPoint(Date productionDate, Shift shift, ControlPoint controlPoint);
}
