package com.trendsmixed.fma.module.drawingversion;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.item.Item;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface DrawingVersionRepository extends PagingAndSortingRepository<DrawingVersion, Integer> {

    @Query(value = "SELECT" + " new com.trendsmixed.fma.dao.Combo(o.id,o.version,CONCAT(o.item.code,''))" + " FROM DrawingVersion o")
    List<Combo> getCombo();

    DrawingVersion findFirstByItemOrderByVersionDesc(Item item);

}
