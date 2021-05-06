package com.trendsmixed.fma.module.usermenu;

import com.trendsmixed.fma.module.menu.Menu;
import com.trendsmixed.fma.module.user.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserMenuService {

    private UserMenuRepository userMenuRepository;

    public List<UserMenu> findAll() {
        return userMenuRepository.findAll();
    }

    public UserMenu save(UserMenu userMenu) {
        return userMenuRepository.save(userMenu);
    }

    public List<UserMenu> save(List<UserMenu> userMenus) {
        return userMenuRepository.saveAll(userMenus);
    }

    public UserMenu findById(int id) {
        return userMenuRepository.findById(id).get();
    }

    public List<Menu> findTopMenuByUser(User user) {
        return userMenuRepository.findTopMenuByUser(user);
    }

    public void deleteById(int id) {
        userMenuRepository.deleteById(id);
    }

    public void delete(List<UserMenu> userMenus) {
        userMenuRepository.deleteAll(userMenus);
    }

    public UserMenu findByUserAndMenu(User user, Menu menu) {
        return userMenuRepository.findByUserAndMenu(user, menu);
    }

    public List<UserMenu> findByUser(User user) {
        return userMenuRepository.findByUserOrderByMenuName(user);
    }

}
