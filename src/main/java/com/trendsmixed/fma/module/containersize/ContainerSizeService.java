package com.trendsmixed.fma.module.containersize;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.trendsmixed.fma.dao.Combo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;

@AllArgsConstructor
@Service
public class ContainerSizeService {

    private ContainerSizeRepository repository;

    public Iterable<ContainerSize> findAll() {
        return repository.findAll();
    }

    public Page<ContainerSize> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public ContainerSize save(ContainerSize containerSize) {
        return repository.save(containerSize);
    }

    public void save(List<ContainerSize> containerSizes) {
        repository.save(containerSizes);
    }

    public ContainerSize findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public ContainerSize findByName(String name) {
        return repository.findByName(name);
    }
}
