package com.trendsmixed.fma.repository;

import com.trendsmixed.fma.entity.PurchaseOrderHasItem;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PurchaseOrderHasItemRepository extends JpaRepository<PurchaseOrderHasItem, Integer> {

}
