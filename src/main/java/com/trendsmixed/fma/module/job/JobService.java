package com.trendsmixed.fma.module.job;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.item.Item;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class JobService {

    private JobRepository repository;

    public Iterable<Job> findAll() {
        return repository.findAll();
    }

    public Page<Job> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public Job save(Job job) {
        return repository.save(job);
    }

    public Iterable<Job> save(List<Job> jobs) {
        return repository.saveAll(jobs);
    }

    public Job findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public Job findByJobNo(String jobNo) {
        return repository.findByJobNo(jobNo);
    }

    public List findX(Date startDate, Date endDate, Pageable pageable) {
        return repository.findX(startDate, endDate, pageable);
    }

    public List findForTable() {
        return repository.findForTable();
    }

    List<Combo> comboByItem(Item item) {
        return repository.comboByItem(item);
    }
    
    Page<Job> findByItem(Item item, Pageable pageable) {
        return repository.findByItem(item, pageable);
    }

    public Page<Job> findByJobNo(String jobNo, Pageable pageable) {
        return repository.findByJobNo(jobNo, pageable);
    }

    public Iterable<Job>  findByJobNoLike(String query) {
        return repository.findByJobNoLike(query);
    }


}


