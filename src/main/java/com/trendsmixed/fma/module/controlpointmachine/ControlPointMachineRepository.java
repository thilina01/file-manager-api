package com.trendsmixed.fma.module.controlpointmachine;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.trendsmixed.fma.entity.ControlPoint;
import com.trendsmixed.fma.entity.ControlPointMachine;
import com.trendsmixed.fma.entity.Machine;

public interface ControlPointMachineRepository extends PagingAndSortingRepository<ControlPointMachine, Integer> {

	ControlPointMachine findByControlPointAndMachine(ControlPoint controlPoint, Machine machine);

}
