package com.trendsmixed.fma.module.organization;

import com.trendsmixed.fma.dao.Combo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class OrganizationService {

    private OrganizationRepository repository;

    public Iterable<Organization> findAll() {
        return repository.findAll();
    }

    public Page<Organization> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public Organization save(Organization organization) {
        return repository.save(organization);
    }

    public Organization findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public Organization findByCode(String code) {
        return repository.findByCode(code);
    }
}
