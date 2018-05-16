package com.trendsmixed.fma.module.customeritem;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.module.item.Item;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CustomerItemService {

    private CustomerItemRepository repository;

    public Iterable<CustomerItem> findAll() {
        return repository.findAll();
    }

    public Page<CustomerItem> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public List<Combo> getComboByCustomer(Customer customer) {
        return repository.getComboByCustomer(customer);
    }

    public CustomerItem save(CustomerItem customerItem) {
        return repository.save(customerItem);
    }

    public void save(List<CustomerItem> customerItems) {
        repository.save(customerItems);
    }

    public CustomerItem findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    Page<CustomerItem> findByCustomer(Customer customer, Pageable pageable) {
        return repository.findByCustomer(customer, pageable);
    }

    public CustomerItem findByCustomerAndItem(Customer customer, Item item) {
        return repository.findByCustomerAndItem(customer, item);
    }

    Page<CustomerItem> findByItem(Item item, Pageable pageable) {
        return repository.findByItem(item, pageable);
    }

    Page<CustomerItem> findByItemAndCustomer(Item item,Customer customer, Pageable pageable) {
        return repository.findByItemAndCustomer(item,customer, pageable);
    }

}
