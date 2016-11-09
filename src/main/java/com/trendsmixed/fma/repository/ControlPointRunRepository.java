package com.trendsmixed.fma.repository;

import com.trendsmixed.fma.entity.ControlPoint;
import com.trendsmixed.fma.entity.ControlPointRun;
import com.trendsmixed.fma.entity.Shift;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ControlPointRunRepository extends JpaRepository<ControlPointRun, Integer> {

    public ControlPointRun findByRunDateAndControlPointAndShift(Date runDate, ControlPoint controlPoint, Shift shift);

}
