package com.trendsmixed.fma.module.salesorder;

import com.trendsmixed.fma.entity.SalesOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesOrderRepository extends JpaRepository<SalesOrder, Integer> {

}
