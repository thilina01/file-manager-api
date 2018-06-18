package com.trendsmixed.fma.module.menu;

import com.trendsmixed.fma.module.menutype.MenuType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Integer> {

    Menu findByName(String name);

    List<Menu> findByMenuIsNull();

    Menu findByNameAndMenuIsNull(String name);

    Menu findByNameAndMenu(String name, Menu menu);

    Menu findByRouterLink(String routerLink);

    List<Menu> findByMenuType(MenuType menuType);

    Menu findByNameAndMenuType(String name, MenuType menuType);

}
