package com.trendsmixed.fma.module.menutype;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class MenuTypeService {

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
        repository.saveAll(menus);
    }

    public MenuType findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public MenuType findByName(String name) {
        return repository.findByName(name);
    }
}
