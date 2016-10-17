package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.MachineRunningTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.repository.MachineRunningTimeRepository;

@Service
public class MachineRunningTimeService {

    @Autowired
    private MachineRunningTimeRepository machineRunningTimeRepository;

    public List<MachineRunningTime> findAll() {
        return machineRunningTimeRepository.findAll();
    }

    public MachineRunningTime save(MachineRunningTime machineRunningTime) {
        return machineRunningTimeRepository.save(machineRunningTime);
    }

    public MachineRunningTime findOne(int id) {
        return machineRunningTimeRepository.findOne(id);
    }

    public void delete(int id) {
        machineRunningTimeRepository.delete(id);
    }
}
