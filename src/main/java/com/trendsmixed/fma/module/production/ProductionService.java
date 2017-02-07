package com.trendsmixed.fma.module.production;

import com.trendsmixed.fma.entity.Production;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.module.production.ProductionRepository;

@Service
public class ProductionService {

    @Autowired
    private ProductionRepository productionRepository;

    public List<Production> findAll() {
        return productionRepository.findAll();
    }

    public Production save(Production production) {
        return productionRepository.save(production);
    }

    public void save(List<Production> productions) {
        productionRepository.save(productions);
    }

    public Production findOne(int id) {
        return productionRepository.findOne(id);
    }

    public void delete(int id) {
        productionRepository.delete(id);
    }

}
