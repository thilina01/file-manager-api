package com.trendsmixed.fma.module.menutype;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.entity.MenuType;
import com.trendsmixed.fma.utility.Page;

@Service
public class MenuTypeService {

    @Autowired
    private MenuTypeRepository repository;

    public Iterable<MenuType> findAll() {
        return repository.findAll();
    }

    public Page<MenuType> findAll(Pageable pageable) {
        return new Page<>(repository.findAll(pageable));
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public MenuType save(MenuType menuType) {
        return repository.save(menuType);
    }

    public void save(List<MenuType> menus) {
        repository.save(menus);
    }

    public MenuType findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public MenuType findByName(String name) {
        return repository.findByName(name);
    }
}
