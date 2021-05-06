package com.trendsmixed.fma.module.menu;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.entity.AppSession;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.module.menutype.MenuType;
import com.trendsmixed.fma.module.menutype.MenuTypeService;
import com.trendsmixed.fma.module.team.Team;
import com.trendsmixed.fma.module.team.TeamService;
import com.trendsmixed.fma.module.teammenu.TeamMenu;
import com.trendsmixed.fma.module.teammenu.TeamMenuService;
import com.trendsmixed.fma.module.user.User;
import com.trendsmixed.fma.module.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/menus")
public class MenuController {

    private final AppSessionService appSessionService;
    private final MenuService menuService;
    private final MenuTypeService menuTypeService;
    private final UserService userService;
    private final TeamService teamService;
    private final TeamMenuService teamMenuService;

    @JsonView(MenuView.AllAndSubMenu.class)
    @GetMapping
    public List<Menu> findAll() {
        return menuService.findAll();
    }

    @JsonView(MenuView.AllAndSuperMenu.class)
    @GetMapping("/withParent")
    public List<Menu> findAllWithParent() {
        return menuService.findAll();
    }

    @JsonView(MenuView.AllAndSubMenu.class)
    @GetMapping("/top")
    public List<Menu> findTop(@RequestHeader(value = "loginTimeMills", defaultValue = "") long loginTimeMills) {

        AppSession appSession = appSessionService.findFirstByLoginTimeMills(loginTimeMills);
        List<Menu> menus = new ArrayList<>();

        if (appSession != null) {
            User user = userService.findByEmail(appSession.getEmail());
            if (user == null) {
                appSessionService.deleteByLoginTimeMills(loginTimeMills);
                return null;
            }

            Team team = user.getTeam();
            if (team == null) {
                team = teamService.findByName("user");
                if (team == null) {
                    team = new Team();
                    team.setName("user");
                    team = teamService.save(team);
                }
                user.setTeam(team);
                user = userService.save(user);
            } else if (team.getName().equalsIgnoreCase("admin")) {
                List<Menu> allMenus = menuService.findAll();
                List<TeamMenu> teamMenus = new ArrayList<>();
                for (Menu menu : allMenus) {
                    TeamMenu teamMenu = teamMenuService.findByTeamAndMenu(team, menu);
                    if (teamMenu == null) {
                        teamMenu = new TeamMenu();
                        teamMenu.setTeam(team);
                        teamMenu.setMenu(menu);
                        teamMenus.add(teamMenu);
                    }
                }
                teamMenus = teamMenuService.save(teamMenus);
                team.setTeamMenuList(teamMenus);
                team = teamService.save(team);

            }
            if (team.getTeamMenuList() != null) {

                menus.addAll(teamMenuService.findTopMenuByTeam(team));
            }
            menus.add(new Menu("Logout", "#logoutModal"));
            menus.add(new Menu("⌕", "#menuGridModal"));
        } else {
            menus.add(new Menu("Login", "#loginModal"));
            menus.add(new Menu("Register", "#registerModal"));
        }

        return menus;
    }

    @PostMapping
    public Menu save(@RequestBody Menu menu) {

        
        try {
            menu = menuService.save(menu);
            return menu;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<Menu> menus) {

        try {
            int i = 0;
            for (Menu menu : menus) {
                MenuType menuType = menu.getMenuType();

                if (menuType == null) {
                    menuType = new MenuType();
                    menuType.setCode("NA");
                    menuType.setName("NA");
                }
                MenuType existingMenuType = menuTypeService.findByName(menuType.getName());
                if (existingMenuType == null) {
                    existingMenuType = menuTypeService.save(menuType);
                }
                menuType.setId(existingMenuType.getId());

                menu.setMenuType(menuType);

                Menu existingMenu = menuService.findByNameAndMenuType(menu.getName(), menuType);

                if (menuType.getName().equalsIgnoreCase("Angular")) {
                    existingMenu = menuService.findByRouterLink(menu.getRouterLink());
                }

                menu.setName(menu.getName().trim());

                if (existingMenu != null) {
                    menu.setId(existingMenu.getId());
                }
                List<Menu> subMenus = menu.getMenuList();
                if (subMenus != null) {
                    for (Menu subMenu : subMenus) {
                        Menu existingSubMenu = menuService.findByNameAndMenu(subMenu.getName(), existingMenu);
                        if (existingSubMenu != null) {
                            subMenu.setId(existingSubMenu.getId());
                        }
                        subMenu.setMenu(menu);
                    }
                }
            }
            menuService.save(menus);
        } catch (Throwable e) {
            e.printStackTrace();
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }

    }

    @GetMapping("/{id}")
    public Menu findOne(@PathVariable("id") int id) {
        return menuService.findById(id);
    }

    @JsonView(MenuView.AllAndSubMenu.class)
    @GetMapping("/menuTypeName/{name}")
    public List<Menu> findByMenuType(@PathVariable("name") String name) {
        return menuService.findByMenuType(menuTypeService.findByName(name));
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        menuService.deleteById(id);

    }

    @PutMapping("/{id}")
    public Menu updateCustomer(@PathVariable int id, @RequestBody Menu menu) {
        
        menu.setId(id);
        menu = menuService.save(menu);
        return menu;
    }

}
