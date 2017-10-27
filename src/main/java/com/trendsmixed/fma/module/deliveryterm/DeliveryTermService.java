package com.trendsmixed.fma.module.deliveryterm;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.trendsmixed.fma.dao.Combo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;

@AllArgsConstructor
@Service
public class DeliveryTermService {

    private DeliveryTermRepository repository;

    public Iterable<DeliveryTerm> findAll() {
        return repository.findAll();
    }

    public Page<DeliveryTerm> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public DeliveryTerm save(DeliveryTerm deliveryTerm) {
        return repository.save(deliveryTerm);
    }

    public void save(List<DeliveryTerm> items) {
        repository.save(items);
    }

    public DeliveryTerm findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public DeliveryTerm findByName(String name) {
        return repository.findByName(name);
    }
}
