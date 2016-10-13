package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.Machine;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.repository.MachineRepository;

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

    public Machine findOne(int id) {
        return machineRepository.findOne(id);
    }

    public void delete(int id) {
        machineRepository.delete(id);
    }
}
