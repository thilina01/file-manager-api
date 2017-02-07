package com.trendsmixed.fma.module.customeritem;

import com.trendsmixed.fma.entity.Customer;
import com.trendsmixed.fma.entity.CustomerItem;
import com.trendsmixed.fma.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerItemRepository extends JpaRepository<CustomerItem, Integer> {

    public CustomerItem findByCustomerAndItem(Customer customer, Item item);

}
