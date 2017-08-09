package com.trendsmixed.fma.module.customeritem;

import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.module.item.Item;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.module.customeritem.CustomerItemRepository;

@Service
public class CustomerItemService {

    @Autowired
    private CustomerItemRepository customerItemRepository;

    public List<CustomerItem> findAll() {
        return customerItemRepository.findAll();
    }

    public CustomerItem save(CustomerItem customerItem) {
        return customerItemRepository.save(customerItem);
    }

    public void save(List<CustomerItem> customerItems) {
        customerItemRepository.save(customerItems);
    }

    public CustomerItem findOne(int id) {
        return customerItemRepository.findOne(id);
    }

    public void delete(int id) {
        customerItemRepository.delete(id);
    }

    public CustomerItem findByCustomerAndItem(Customer customer, Item item) {
        return customerItemRepository.findByCustomerAndItem(customer, item);
    }
}
