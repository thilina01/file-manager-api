package com.trendsmixed.fma.module.customeritem;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.module.item.Item;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerItemRepository extends PagingAndSortingRepository<CustomerItem, Integer> {

    CustomerItem findByCustomerAndItem(Customer customer, Item item);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM CustomerItem o")
    List<Combo> getCombo();
}
