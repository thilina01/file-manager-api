package com.trendsmixed.fma.module.usermenu;

import com.trendsmixed.fma.module.menu.Menu;
import com.trendsmixed.fma.module.user.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserMenuRepository extends JpaRepository<UserMenu, Integer> {

    @Query(value = "select userMenu.menu from UserMenu userMenu where userMenu.user= :user And userMenu.menu.menu IS NULL ")
    public List<Menu> findTopMenuByUser(@Param("user") User user);

    public UserMenu findByUserAndMenu(User user, Menu menu);

    public List<UserMenu> findByUser(User user);

}
