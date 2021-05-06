package com.trendsmixed.fma.module.containersize;

import com.trendsmixed.fma.dao.Combo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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
        repository.saveAll(containerSizes);
    }

    public ContainerSize findById(int id) {
        return repository.findById(id).get();
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public ContainerSize findByName(String name) {
        return repository.findByName(name);
    }
}
