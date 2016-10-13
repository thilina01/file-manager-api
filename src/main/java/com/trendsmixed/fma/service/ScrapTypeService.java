package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.ScrapType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.repository.ScrapTypeRepository;

@Service
public class ScrapTypeService {

    @Autowired
    private ScrapTypeRepository scrapTypeRepository;

    public List<ScrapType> findAll() {
        return scrapTypeRepository.findAll();
    }

    public ScrapType save(ScrapType scrapType) {
        return scrapTypeRepository.save(scrapType);
    }

    public ScrapType findOne(int id) {
        return scrapTypeRepository.findOne(id);
    }

    public void delete(int id) {
        scrapTypeRepository.delete(id);
    }
}
