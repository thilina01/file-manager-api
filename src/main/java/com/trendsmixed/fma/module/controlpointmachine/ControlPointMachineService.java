package com.trendsmixed.fma.module.controlpointmachine;

import com.trendsmixed.fma.module.controlpoint.ControlPoint;
import com.trendsmixed.fma.module.machine.Machine;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ControlPointMachineService {

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
        repository.saveAll(controlPointMachines);
    }

    public ControlPointMachine findById(int id) {
        return repository.findById(id).get();
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public ControlPointMachine findByControlPointAndMachine(ControlPoint controlPoint, Machine machine) {
        return repository.findByControlPointAndMachine(controlPoint, machine);
    }
}
