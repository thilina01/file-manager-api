package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.Dispatch;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.repository.DispatchRepository;

@Service
public class DispatchService {

    @Autowired
    private DispatchRepository dispatchRepository;

    public List< Dispatch> findAll() {
        return dispatchRepository.findAll();
    }

    public Dispatch save(Dispatch dispatch) {
        return dispatchRepository.save(dispatch);
    }

    public Dispatch findOne(int id) {
        return dispatchRepository.findOne(id);
    }

    public void delete(int id) {
        dispatchRepository.delete(id);
    }
}
