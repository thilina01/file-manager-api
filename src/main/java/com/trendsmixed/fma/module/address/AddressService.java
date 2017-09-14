package com.trendsmixed.fma.module.address;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.customer.Customer;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository repository;

    public Iterable<Address> findAll() {
        return repository.findAll();
    }

    public Page<Address> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }
    
    public List<Combo> getComboByCustomer(Customer customer) {
        return repository.getComboByCustomer(customer);
    }

    public Address save(Address address) {
        return repository.save(address);
    }

    public Address findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public Address findByCode(String code) {
        return repository.findByCode(code);
    }
}
