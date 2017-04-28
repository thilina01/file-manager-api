package com.trendsmixed.fma.module.controlpointmachine;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.entity.ControlPoint;
import com.trendsmixed.fma.entity.ControlPointMachine;
import com.trendsmixed.fma.entity.Machine;
import com.trendsmixed.fma.utility.Page;

@Service
public class ControlPointMachineService {

    @Autowired
    private ControlPointMachineRepository repository;

    public Iterable<ControlPointMachine> findAll() {
        return repository.findAll();
    }

	public Page<ControlPointMachine> findAll(Pageable pageable) {
		return new Page<ControlPointMachine>(repository.findAll(pageable));
	}

    public ControlPointMachine save(ControlPointMachine controlPointMachine) {
        return repository.save(controlPointMachine);
    }

    public void save(List<ControlPointMachine> controlPointMachines) {
        repository.save(controlPointMachines);
    }

    public ControlPointMachine findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public ControlPointMachine findByControlPointAndMachine(ControlPoint controlPoint, Machine machine) {
        return repository.findByControlPointAndMachine(controlPoint,machine);
    }
}
