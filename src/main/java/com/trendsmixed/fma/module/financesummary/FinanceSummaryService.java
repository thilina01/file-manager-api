package com.trendsmixed.fma.module.financesummary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FinanceSummaryService {

    @Autowired
    private FinanceSummaryRepository repository;

    public Iterable<FinanceSummary> findAll() {
        return repository.findAll();
    }

    public Page<FinanceSummary> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public FinanceSummary save(FinanceSummary financeSummary) {
        return repository.save(financeSummary);
    }

    public void save(List<FinanceSummary> financeSummarys) {
        repository.save(financeSummarys);
    }

    public FinanceSummary findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

}
