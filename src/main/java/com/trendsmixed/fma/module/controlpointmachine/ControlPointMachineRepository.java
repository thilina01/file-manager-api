package com.trendsmixed.fma.module.controlpointmachine;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.trendsmixed.fma.module.controlpoint.ControlPoint;
import com.trendsmixed.fma.module.machine.Machine;

public interface ControlPointMachineRepository extends PagingAndSortingRepository<ControlPointMachine, Integer> {

    ControlPointMachine findByControlPointAndMachine(ControlPoint controlPoint, Machine machine);

}
