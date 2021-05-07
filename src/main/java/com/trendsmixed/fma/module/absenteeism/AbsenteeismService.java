package com.trendsmixed.fma.module.absenteeism;

import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AbsenteeismService {

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

    public void save(List<Absenteeism> absenteeisms) {
        repository.saveAll(absenteeisms);
    }

    public Absenteeism findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

}
