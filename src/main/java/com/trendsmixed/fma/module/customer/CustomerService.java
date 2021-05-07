package com.trendsmixed.fma.module.customer;

import com.trendsmixed.fma.dao.Combo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CustomerService {

    private CustomerRepository repository;

    public Iterable<Customer> findAll() {
        return repository.findAll();
    }

    public Page<Customer> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public Customer save(Customer customer) {
        return repository.save(customer);
    }

    public void save(List<Customer> customers) {
        repository.saveAll(customers);
    }

    public Customer findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public Customer findByCode(String code) {
        return repository.findByCode(code);
    }

    public Customer findByName(String name) {
        return repository.findByName(name);
    }
}
