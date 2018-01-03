package com.trendsmixed.fma.module.resourceutilization;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@AllArgsConstructor
@Service
public class ResourceUtilizationService {

    private ResourceUtilizationRepository repository;

    public Iterable<ResourceUtilization> findAll() {
        return repository.findAll();
    }

    public Page<ResourceUtilization> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public ResourceUtilization save(ResourceUtilization costCenter) {
        return repository.save(costCenter);
    }

    public void save(List<ResourceUtilization> costCenters) {
        repository.save(costCenters);
    }

    public ResourceUtilization findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }


}
