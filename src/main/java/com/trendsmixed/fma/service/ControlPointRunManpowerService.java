package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.ControlPointRunManpower;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.repository.ControlPointRunManpowerRepository;
import java.util.Date;
import org.springframework.data.domain.Pageable;

@Service
public class ControlPointRunManpowerService {

    @Autowired
    private ControlPointRunManpowerRepository controlPointRunManpowerRepository;

    public List<ControlPointRunManpower> findAll() {
        return controlPointRunManpowerRepository.findAll();
    }

    public ControlPointRunManpower save(ControlPointRunManpower ControlPointRunManpower) {
        return controlPointRunManpowerRepository.save(ControlPointRunManpower);
    }

    public ControlPointRunManpower findOne(int id) {
        return controlPointRunManpowerRepository.findOne(id);
    }

    public void delete(int id) {
        controlPointRunManpowerRepository.delete(id);
    }

    public List findSumByManpowerTypeAndDateBetween(Date startDate, Date endDate, Pageable pageable) {
        return controlPointRunManpowerRepository.findSumByManpowerTypeAndDateBetween(startDate, endDate, pageable);
    }

}
