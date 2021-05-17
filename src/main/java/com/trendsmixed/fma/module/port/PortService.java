package com.trendsmixed.fma.module.port;

import com.trendsmixed.fma.dao.Combo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PortService {

    private PortRepository repository;

    public Iterable<Port> findAll() {
        return repository.findAll();
    }

    public Page<Port> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public Port save(Port port) {
        return repository.save(port);
    }

    public void save(List<Port> ports) {
        repository.saveAll(ports);
    }

    public Port findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public Port findByCode(String code) {
        return repository.findByCode(code);
    }

    public Port findByName(String name) {
        return repository.findByName(name);
    }

    public List <Port> findByAddressListCustomerId(int customerId) {
        return repository.findByAddressListCustomerId(customerId);
    }
}
