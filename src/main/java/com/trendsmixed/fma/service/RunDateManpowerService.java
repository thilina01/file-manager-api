package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.RunDateManpower;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.repository.RunDateManpowerRepository;

@Service
public class RunDateManpowerService {

    @Autowired
    private RunDateManpowerRepository runDateManpowerRepository;

    public List<RunDateManpower> findAll() {
        return runDateManpowerRepository.findAll();
    }

    public RunDateManpower save(RunDateManpower runDateManpower) {
        return runDateManpowerRepository.save(runDateManpower);
    }

    public RunDateManpower findOne(int id) {
        return runDateManpowerRepository.findOne(id);
    }

    public void delete(int id) {
        runDateManpowerRepository.delete(id);
    }
}
