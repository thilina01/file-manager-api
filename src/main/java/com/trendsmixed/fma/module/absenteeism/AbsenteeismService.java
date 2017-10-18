package com.trendsmixed.fma.module.absenteeism;

import com.trendsmixed.fma.utility.Page;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AbsenteeismService {

    @Autowired
    private AbsenteeismRepository repository;

    public Iterable<Absenteeism> findAll() {
        return repository.findAll();
    }

    public Page<Absenteeism> findAll(Pageable pageable) {
        return new Page<>(repository.findAll(pageable));
    }

    public Absenteeism save(Absenteeism absenteeism) {
        return repository.save(absenteeism);
    }

    public void save(List<Absenteeism> countries) {
        repository.save(countries);
    }

    public Absenteeism findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

}
