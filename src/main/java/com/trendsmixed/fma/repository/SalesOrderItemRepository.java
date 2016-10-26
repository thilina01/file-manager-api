package com.trendsmixed.fma.repository;

import com.trendsmixed.fma.entity.SalesOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesOrderItemRepository extends JpaRepository<SalesOrderItem, Integer> {

}
