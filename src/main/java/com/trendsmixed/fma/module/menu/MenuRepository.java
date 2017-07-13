package com.trendsmixed.fma.module.menu;

import com.trendsmixed.fma.entity.Menu;
import com.trendsmixed.fma.entity.MenuType;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Integer> {

    Menu findByName(String name);

    public List<Menu> findByMenuIsNull();

    public Menu findByNameAndMenuIsNull(String name);

    public Menu findByNameAndMenu(String name, Menu menu);

    public Menu findByRouterLink(String routerLink);

    public List<Menu> findByMenuType(MenuType menuType);

    public Menu findByNameAndMenuType(String name, MenuType menuType);

}
