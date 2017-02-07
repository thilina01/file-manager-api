package com.trendsmixed.fma.module.customer;

import com.trendsmixed.fma.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    public Customer findByCode(String code);

}
