package com.trendsmixed.fma.module.shift;

import com.trendsmixed.fma.entity.Shift;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShiftRepository extends JpaRepository<Shift, Integer> {

    public Shift findByCode(String code);

}
