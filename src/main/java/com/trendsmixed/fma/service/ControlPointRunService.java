package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.ControlPoint;
import com.trendsmixed.fma.entity.ControlPointRun;
import com.trendsmixed.fma.entity.Shift;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.repository.ControlPointRunRepository;
import java.util.ArrayList;
import java.util.Date;

@Service
public class ControlPointRunService {

    @Autowired
    private ControlPointRunRepository controlPointRunRepository;

    public List<ControlPointRun> findAll() {
        return controlPointRunRepository.findAll();
    }

    public ControlPointRun save(ControlPointRun ControlPointRun) {
        return controlPointRunRepository.save(ControlPointRun);
    }

    public ControlPointRun findOne(int id) {
        return controlPointRunRepository.findOne(id);
    }

    public void delete(int id) {
        controlPointRunRepository.delete(id);
    }

    public ControlPointRun findByRunDateAndControlPointAndShift(Date runDate, ControlPoint controlPoint, Shift shift) {
        return controlPointRunRepository.findByRunDateAndControlPointAndShift(runDate, controlPoint, shift);
    }

    public List<ControlPointRun> save(List<ControlPointRun> controlPointRuns) {
        return controlPointRunRepository.save(controlPointRuns);
    }

    public List<ControlPointRun> findByRunDateBetween(Date startDate, Date endDate) {
        return controlPointRunRepository.findByRunDateBetween(startDate, endDate);
    }

    public List<ControlPointRun> findByRunDateBetweenOrderByRunDate(Date startDate, Date endDate) {
        return controlPointRunRepository.findByRunDateBetweenOrderByRunDate(startDate, endDate);
    }

    public List<ControlPointRun> findControlPointDistinctByRunDateBetweenOrderByRunDate(Date startDate, Date endDate) {
        return controlPointRunRepository.findControlPointDistinctByRunDateBetweenOrderByRunDate(startDate, endDate);
    }

    public long countControlPointDistinctByRunDateBetweenOrderByRunDate(Date startDate, Date endDate) {
        return controlPointRunRepository.countControlPointDistinctByRunDateBetweenOrderByRunDate(startDate, endDate);
    }

    public ArrayList findSectionWiseMttrDateBetween(Date startDate, Date endDate) {
        return controlPointRunRepository.findSectionWiseMttrDateBetween(startDate, endDate);
    }

    public ArrayList findSectionWiseMtbfDateBetween(Date startDate, Date endDate) {
        return controlPointRunRepository.findSectionWiseMtbfDateBetween(startDate, endDate);
    }

    public ArrayList findSectionWiseMdtDateBetween(Date startDate, Date endDate) {
        return controlPointRunRepository.findSectionWiseMdtDateBetween(startDate, endDate);
    }

}
