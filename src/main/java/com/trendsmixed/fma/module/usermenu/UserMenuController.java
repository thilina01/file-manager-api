package com.trendsmixed.fma.module.usermenu;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.menu.Menu;
import com.trendsmixed.fma.module.user.User;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.module.user.UserService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/userMenus")
public class UserMenuController {

    private final AppSessionService appSessionService;
    private final UserMenuService userMenuService;
    private final UserService userService;

    @PutMapping
    public List<UserMenu> saveMany(@RequestBody List<UserMenu> userMenus, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
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
    public void toggle(
            @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request,
            @PathVariable("userId") int userId,
            @PathVariable("menuId") int menuId) {
        //System.out.println("RRRRR " + email);
        //appSessionService.isValid(email, request);
        try {
            UserMenu userMenu = userMenuService.findByUserAndMenu(new User(userId), new Menu(menuId));
            if (userMenu != null) {
                userMenuService.delete(userMenu.getId());
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
    public List<UserMenu> findByUserId(
            @RequestHeader(value = "email", defaultValue = "") String email, @PathVariable("userEmail") String userEmail) {
        //System.out.println(userEmail);
        System.out.println(email);
        User user = userService.findByEmail(email);
        System.out.println(user != null ? user.getId() : "Null");
        return userMenuService.findByUser(new User(user != null ? user.getId() : 0));
    }

    @JsonView(UserMenuView.Menu.class)
    @GetMapping("/own")
    public List<UserMenu> own(
            @RequestHeader(value = "email", defaultValue = "") String email) {
        User user = userService.findByEmail(email);
        System.out.println(user != null ? user.getId() : "Null");
        return userMenuService.findByUser(new User(user != null ? user.getId() : 0));
    }
}
