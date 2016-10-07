package com.trendsmixed.fma.repository;

import com.trendsmixed.fma.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {


}
