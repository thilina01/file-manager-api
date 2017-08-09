package com.trendsmixed.fma.module.labourturnover;

import com.trendsmixed.fma.utility.Page;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LabourTurnoverService {

    @Autowired
    private LabourTurnoverRepository repository;

    public Iterable<LabourTurnover> findAll() {
        return repository.findAll();
    }

    public Page<LabourTurnover> findAll(Pageable pageable) {
        return new Page<>(repository.findAll(pageable));
    }

    public LabourTurnover save(LabourTurnover labourTurnover) {
        return repository.save(labourTurnover);
    }

    public void save(List<LabourTurnover> countries) {
        repository.save(countries);
    }

    public LabourTurnover findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

}
