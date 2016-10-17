package com.trendsmixed.fma.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.AppSession;
import com.trendsmixed.fma.dao.Menu;
import com.trendsmixed.fma.service.AppSessionService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController
@CrossOrigin
@RequestMapping("/menus")
public class MenuController {

    @Autowired
    private AppSessionService appSessionService;

    @GetMapping
    public ArrayList<Menu> getMenus(@RequestHeader(value = "email", defaultValue = "") String email) {
        ArrayList<Menu> menus = new ArrayList<>();
        //System.out.println(email);      
        //AppSession appSession = null;
        //if (!email.equals("")) {}
        AppSession appSession = appSessionService.findOne(email);

        if (appSession != null) {
            menus.add(new Menu("Logout", "#logoutModal"));
        } else {
            menus.add(new Menu("Login", "#loginModal"));
            menus.add(new Menu("Register", "#registerModal"));
        }

        return menus;
    }

}
