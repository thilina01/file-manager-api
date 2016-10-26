package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.RunDateScrap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.repository.RunDateScrapRepository;

@Service
public class RunDateScrapService {

    @Autowired
    private RunDateScrapRepository runDateScrapRepository;

    public List<RunDateScrap> findAll() {
        return runDateScrapRepository.findAll();
    }

    public RunDateScrap save(RunDateScrap runDateScrap) {
        return runDateScrapRepository.save(runDateScrap);
    }

    public RunDateScrap findOne(int id) {
        return runDateScrapRepository.findOne(id);
    }

    public void delete(int id) {
        runDateScrapRepository.delete(id);
    }
}
