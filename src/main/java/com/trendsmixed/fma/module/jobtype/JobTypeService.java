package com.trendsmixed.fma.module.jobtype;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class JobTypeService {

    private JobTypeRepository repository;

    public Iterable<JobType> findAll() {
        return repository.findAll();
    }

    public Page<JobType> findAll(Pageable pageable) {
        return new Page<JobType>(repository.findAll(pageable));
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public JobType save(JobType jobType) {
        return repository.save(jobType);
    }

    public JobType findById(int id) {
        return repository.findById(id).get();
    }

    public JobType findByCode(String code) {
        return repository.findByCode(code);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

}
