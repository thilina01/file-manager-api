package com.trendsmixed.fma.module.machine;

import com.trendsmixed.fma.entity.Machine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MachineRepository extends JpaRepository<Machine, Integer> {

    public Machine findByCode(String code);

}
