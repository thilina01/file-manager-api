package com.trendsmixed.fma.module.jobtype;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;

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

    public JobType findOne(int id) {
        return repository.findOne(id);
    }

    public JobType findByCode(String code) {
        return repository.findByCode(code);
    }

    public void delete(int id) {
        repository.delete(id);
    }

}
