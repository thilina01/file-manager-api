package com.trendsmixed.fma.module.packagingspecification;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PackagingSpecificationService {

    private PackagingSpecificationRepository repository;

    public Iterable<PackagingSpecification> findAll() {
        return repository.findAll();
    }

    public Page<PackagingSpecification> findAll(Pageable pageable) {
        return new Page<PackagingSpecification>(repository.findAll(pageable));
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public PackagingSpecification save(PackagingSpecification packagingSpecification) {
        return repository.save(packagingSpecification);
    }

    public PackagingSpecification findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

}
