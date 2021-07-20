package com.trendsmixed.fma.module.routing;

import com.trendsmixed.fma.dao.Combo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RoutingService {

    private RoutingRepository repository;

    public Iterable<Routing> findAll() {
        return repository.findAll();
    }

    public Page<Routing> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public Routing save(Routing routing) {
        return repository.save(routing);
    }

    public Iterable<Routing> save(List<Routing> routings) {
        return repository.saveAll(routings);
    }

    public Routing findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

}
