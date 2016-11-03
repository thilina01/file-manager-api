package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.ControlPointRunLoss;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.repository.ControlPointRunLossRepository;

@Service
public class ControlPointRunLossService {

    @Autowired
    private ControlPointRunLossRepository controlPointRunLossRepository;

    public List<ControlPointRunLoss> findAll() {
        return controlPointRunLossRepository.findAll();
    }

    public ControlPointRunLoss save(ControlPointRunLoss ControlPointRunLoss) {
        return controlPointRunLossRepository.save(ControlPointRunLoss);
    }

    public ControlPointRunLoss findOne(int id) {
        return controlPointRunLossRepository.findOne(id);
    }

    public void delete(int id) {
        controlPointRunLossRepository.delete(id);
    }
}

