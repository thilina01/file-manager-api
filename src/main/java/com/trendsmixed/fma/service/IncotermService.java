package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.Incoterm;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.repository.IncotermRepository;

@Service
public class IncotermService {

    @Autowired
    private IncotermRepository incotermRepository;

    public List<Incoterm> findAll() {
        return incotermRepository.findAll();
    }

    public Incoterm save(Incoterm incoterm) {
        return incotermRepository.save(incoterm);
    }

    public Incoterm findOne(int id) {
        return incotermRepository.findOne(id);
    }

    public void delete(int id) {
        incotermRepository.delete(id);
    }

    public Incoterm findByCode(String code) {
        return incotermRepository.findByCode(code);
    }
}
