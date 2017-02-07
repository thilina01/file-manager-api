package com.trendsmixed.fma.module.machine;

import com.trendsmixed.fma.entity.Machine;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.module.machine.MachineRepository;

@Service
public class MachineService {

    @Autowired
    private MachineRepository machineRepository;

    public List<Machine> findAll() {
        return machineRepository.findAll();
    }

    public Machine save(Machine machine) {
        return machineRepository.save(machine);
    }

    public void save(List<Machine> machines) {
        machineRepository.save(machines);
    }

    public Machine findOne(int id) {
        return machineRepository.findOne(id);
    }

    public void delete(int id) {
        machineRepository.delete(id);
    }

    public Machine findByCode(String code) {
        return machineRepository.findByCode(code);
    }
}
