package com.trendsmixed.fma.module.customeritem;

import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.module.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerItemRepository extends JpaRepository<CustomerItem, Integer> {

    public CustomerItem findByCustomerAndItem(Customer customer, Item item);

}
