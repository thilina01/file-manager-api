package com.trendsmixed.fma.module.containersize;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.trendsmixed.fma.dao.Combo;

public interface ContainerSizeRepository extends PagingAndSortingRepository<ContainerSize, Integer> {

    public ContainerSize findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM ContainerSize o")
    public List<Combo> getCombo();
}
