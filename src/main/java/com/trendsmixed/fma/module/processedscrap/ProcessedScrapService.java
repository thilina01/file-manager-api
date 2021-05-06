package com.trendsmixed.fma.module.processedscrap;

import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProcessedScrapService {

    private ProcessedScrapRepository repository;

    public Iterable<ProcessedScrap> findAll() {
        return repository.findAll();
    }

    public Page<ProcessedScrap> findAll(Pageable pageable) {
        return new Page<>(repository.findAll(pageable));
    }

    public ProcessedScrap save(ProcessedScrap processedScrap) {
        return repository.save(processedScrap);
    }

    public void save(List<ProcessedScrap> processedScraps) {
        repository.saveAll(processedScraps);
    }

    public ProcessedScrap findById(int id) {
        return repository.findById(id).get();
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

}
