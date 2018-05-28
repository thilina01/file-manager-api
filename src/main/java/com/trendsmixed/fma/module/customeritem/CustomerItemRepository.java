package com.trendsmixed.fma.module.customeritem;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.module.item.Item;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerItemRepository extends PagingAndSortingRepository<CustomerItem, Integer> {

        CustomerItem findByCustomerAndItem(Customer customer, Item item);

        @Query(value = "SELECT" + " new com.trendsmixed.fma.dao.Combo(o.id, o.code,CONCAT(o.item.code,'') )" + " FROM CustomerItem o")
        List<Combo> getCombo();

        Iterable<CustomerItem> findByCustomer(Customer customer);

        @Query(value = "SELECT" + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)" + " FROM CustomerItem o"
                        + " WHERE o.customer = :customer")
        List<Combo> getComboByCustomer(@Param("customer") Customer customer);

        Page<CustomerItem> findByCustomer(Customer customer, Pageable pageable);

        Page<CustomerItem> findByItem(Item item, Pageable pageable);

        Page<CustomerItem> findByItemAndCustomer(Item item, Customer customer, Pageable pageable);

        Page<CustomerItem> findByCode(String code, Pageable pageable);


}
