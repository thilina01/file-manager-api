package com.trendsmixed.fma.module.controlpoint;

import com.trendsmixed.fma.entity.ControlPoint;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.module.controlpoint.ControlPointRepository;

@Service
public class ControlPointService {

    @Autowired
    private ControlPointRepository controlPointRepository;

    public List<ControlPoint> findAll() {
        return controlPointRepository.findAll();
    }

    public ControlPoint save(ControlPoint ControlPoint) {
        return controlPointRepository.save(ControlPoint);
    }

    public void save(List<ControlPoint> controlPoints) {
        controlPointRepository.save(controlPoints);
    }

    public ControlPoint findOne(int id) {
        return controlPointRepository.findOne(id);
    }

    public void delete(int id) {
        controlPointRepository.delete(id);
    }

    public ControlPoint findByCode(String code) {
        return controlPointRepository.findByCode(code);
    }
}
