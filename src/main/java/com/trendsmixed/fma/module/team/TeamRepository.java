package com.trendsmixed.fma.module.team;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TeamRepository extends JpaRepository<Team, Integer> {

    Team findByName(String name);

}
