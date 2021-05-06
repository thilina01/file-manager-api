package com.trendsmixed.fma.module.usermenu;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.module.menu.Menu;
import com.trendsmixed.fma.module.user.User;
import com.trendsmixed.fma.module.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/userMenus")
public class UserMenuController {

    private final UserMenuService userMenuService;
    private final UserService userService;
    private final AppSessionService appSessionService;

    @PutMapping
    public List<UserMenu> saveMany(@RequestBody List<UserMenu> userMenus) {

        try {
            if (!userMenus.isEmpty()) {
                User user = userMenus.get(0).getUser();
                userMenuService.delete(userMenuService.findByUser(user));
                userMenus = userMenuService.save(userMenus);
            }
            return userMenus;
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("toggle/{userId}/{menuId}")
    public void toggle(@PathVariable("userId") int userId, @PathVariable("menuId") int menuId) {
        // System.out.println("RRRRR " + email);
        //
        try {
            UserMenu userMenu = userMenuService.findByUserAndMenu(new User(userId), new Menu(menuId));
            if (userMenu != null) {
                userMenuService.deleteById(userMenu.getId());
            } else {
                userMenu = new UserMenu();
                userMenu.setUser(new User(userId));
                userMenu.setMenu(new Menu(menuId));
                userMenuService.save(userMenu);
            }

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(UserMenuView.Menu.class)
    @GetMapping("/userId/{userId}")
    public List<UserMenu> findByUserId(@PathVariable("userId") int userId) {
        return userMenuService.findByUser(new User(userId));
    }

    @JsonView(UserMenuView.Menu.class)
    @GetMapping("/userEmail/{userEmail}")
    public List<UserMenu> findByUserId(@PathVariable("userEmail") String userEmail) {
        // System.out.println(userEmail);
        System.out.println(userEmail);
        User user = userService.findByEmail(userEmail);
        System.out.println(user != null ? user.getId() : "Null");
        return userMenuService.findByUser(new User(user != null ? user.getId() : 0));
    }

    @JsonView(UserMenuView.Menu.class)
    @GetMapping("/own")
    public List<UserMenu> own(@RequestHeader(value = "loginTimeMills", defaultValue = "") long loginTimeMills) {
        String email = appSessionService.findFirstByLoginTimeMills(loginTimeMills).getEmail();
        User user = userService.findByEmail(email);
        System.out.println(user != null ? user.getId() : "Null");
        return userMenuService.findByUser(new User(user != null ? user.getId() : 0));
    }
}
