package com.trendsmixed.fma.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.AppSession;
import com.trendsmixed.fma.dao.Menu;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/menusX")
public class MenuControllerX {

    private final AppSessionService appSessionService;

    @GetMapping
    public ArrayList<Menu> getMenus(@RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        ArrayList<Menu> menus = new ArrayList<>();

        AppSession appSession = appSessionService.findOne(email);

        Menu planningMenu = new Menu("Planning", "", "#/kpi");
        planningMenu.getMenus().add(new Menu("Planning", "#controlPointPlanModal"));
        menus.add(planningMenu);

        if (appSession != null) {
            menus.add(new Menu("Logout", "#logoutModal"));
        } else {
            menus.add(new Menu("Login", "#loginModal"));
            menus.add(new Menu("Register", "#registerModal"));
        }

        Menu testMenu2 = new Menu("M2", "M2", "M2");
        menus.add(testMenu2);
        return menus;
    }

}
