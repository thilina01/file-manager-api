package com.trendsmixed.fma.module.breakdown;

import com.trendsmixed.fma.entity.Breakdown;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BreakdownService {

    @Autowired
    private BreakdownRepository breakdownRepository;

    public List<Breakdown> findAll() {
        return breakdownRepository.findAll();
    }

    public Breakdown save(Breakdown breakdown) {
        return breakdownRepository.save(breakdown);
    }

    public Breakdown findOne(int id) {
        return breakdownRepository.findOne(id);
    }

    public void delete(int id) {
        breakdownRepository.delete(id);
    }
}
