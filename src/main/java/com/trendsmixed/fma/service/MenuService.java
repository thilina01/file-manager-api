package com.trendsmixed.fma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.entity.Menu;
import com.trendsmixed.fma.repository.MenuRepository;

@Service
public class MenuService {

    @Autowired
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

    public Menu findByNameAndMenu(String name, Menu menu) {
        return menuRepository.findByNameAndMenu(name, menu);
    }

}
