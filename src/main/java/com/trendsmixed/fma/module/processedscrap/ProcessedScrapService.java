package com.trendsmixed.fma.module.processedscrap;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;

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

    public void save(List<ProcessedScrap> menus) {
        repository.save(menus);
    }

    public ProcessedScrap findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

}
