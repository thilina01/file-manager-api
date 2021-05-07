package com.trendsmixed.fma.module.financesummary;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class FinanceSummaryService {

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

    public void save(List<FinanceSummary> financeSummaries) {
        repository.saveAll(financeSummaries);
    }

    public FinanceSummary findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

}
