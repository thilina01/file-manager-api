package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.Customer;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public void save(List<Customer> customers) {
        customerRepository.save(customers);
    }

    public Customer findOne(int id) {
        return customerRepository.findOne(id);
    }

    public void delete(int id) {
        customerRepository.delete(id);
    }
}
