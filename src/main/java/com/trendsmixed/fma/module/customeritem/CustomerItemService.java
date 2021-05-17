package com.trendsmixed.fma.module.customeritem;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.module.item.Item;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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
        repository.saveAll(customerItems);
    }

    public CustomerItem findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
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

    public Iterable<CustomerItem> findByCustomer(Customer customer) {
        return repository.findByCustomer(customer);
    }

    Page<CustomerItem> findByCode(String code, Pageable pageable) {
        return repository.findByCode(code, pageable);
    }

}
