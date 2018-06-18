package com.trendsmixed.fma.module.palletsize;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PalletSizeRepository extends PagingAndSortingRepository<PalletSize, Integer> {

    @Query(value = "SELECT" + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)" + " FROM PalletSize o")

    List<Combo> getCombo();
}