package com.trendsmixed.fma.module.usermenu;

import com.trendsmixed.fma.module.menu.Menu;
import com.trendsmixed.fma.module.user.User;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMenuService {

    @Autowired
    private UserMenuRepository userMenuRepository;

    public List<UserMenu> findAll() {
        return userMenuRepository.findAll();
    }

    public UserMenu save(UserMenu userMenu) {
        return userMenuRepository.save(userMenu);
    }

    public List<UserMenu> save(List<UserMenu> userMenus) {
        return userMenuRepository.save(userMenus);
    }

    public UserMenu findOne(int id) {
        return userMenuRepository.findOne(id);
    }

    public List<Menu> findTopMenuByUser(User user) {
        return userMenuRepository.findTopMenuByUser(user);
    }

    public void delete(int id) {
        userMenuRepository.delete(id);
    }

    public void delete(List<UserMenu> userMenus) {
        userMenuRepository.delete(userMenus);
    }

    public UserMenu findByUserAndMenu(User user, Menu menu) {
        return userMenuRepository.findByUserAndMenu(user, menu);
    }

    public List<UserMenu> findByUser(User user) {
        return userMenuRepository.findByUserOrderByMenuName(user);
    }

}
