package com.trendsmixed.fma.repository;

import com.trendsmixed.fma.entity.Menu;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Integer> {

    Menu findByName(String name);

    public List<Menu> findByMenuIsNull();

    public Menu findByNameAndMenuIsNull(String name);

    public Menu findByNameAndMenu(String name, Menu menu);

}
