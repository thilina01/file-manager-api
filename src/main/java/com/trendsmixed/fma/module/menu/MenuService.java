package com.trendsmixed.fma.module.menu;

import java.util.List;
import org.springframework.stereotype.Service;
import com.trendsmixed.fma.module.menutype.MenuType;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MenuService {

    private MenuRepository menuRepository;

    public List<Menu> findAll() {
        return menuRepository.findAll();
    }

    public Menu save(Menu menu) {
        return menuRepository.save(menu);
    }

    public List<Menu> save(List<Menu> menus) {
        return menuRepository.save(menus);
    }

    public Menu findOne(int id) {
        return menuRepository.findOne(id);
    }

    public void delete(int id) {
        menuRepository.delete(id);
    }

    public Menu findByName(String name) {
        return menuRepository.findByName(name);

    }

    public List<Menu> findByMenuIsNull() {
        return menuRepository.findByMenuIsNull();
    }

    public Menu findByNameAndMenuIsNull(String name) {
        return menuRepository.findByNameAndMenuIsNull(name);
    }

    public Menu findByRouterLink(String routerLink) {
        return menuRepository.findByRouterLink(routerLink);
    }

    public Menu findByNameAndMenu(String name, Menu menu) {
        return menuRepository.findByNameAndMenu(name, menu);
    }

    public Menu findByNameAndMenuType(String name, MenuType menuType) {
        return menuRepository.findByNameAndMenuType(name, menuType);
    }

    List<Menu> findByMenuType(MenuType menuType) {
        return menuRepository.findByMenuType(menuType);
    }

}
