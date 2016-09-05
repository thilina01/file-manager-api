package com.trendsmixed.fma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.dao.UserDao;
import com.trendsmixed.fma.entity.AppSession;
import com.trendsmixed.fma.service.AppSessionService;
import com.trendsmixed.fma.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private UserService userService;
    @Autowired
    private AppSessionService appSessionService;

    @PostMapping("/register")
    public boolean register(@RequestBody UserDao userDao, HttpServletRequest request) {
        userDao.setUserService(userService);
        boolean success = userDao.save();
        if (success) {
            saveAppSession(userDao.getEmail(), request.getRemoteAddr());
        }
        return success;
    }

    @PostMapping("/login")
    public boolean login(@RequestBody UserDao userDao, HttpServletRequest request, HttpServletResponse response) {
        userDao.setUserService(userService);
        boolean success = userDao.isAuthenticated();
        if (success) {
                saveAppSession(userDao.getEmail(), request.getRemoteAddr());
               // Cookie cookie = new Cookie("XXXX", "TTTTTTTTTTTTTTTTTTTT");
                //cookie.setDomain("http://localhost");
                //cookie.setPath("/");
                //response.addCookie(cookie);
                //response.flushBuffer();
        }
        return success;
    }

    @PostMapping("/logout")
    public void logout(@RequestBody UserDao userDao) {
        appSessionService.delete(userDao.getEmail());

        System.out.println(userDao.getEmail());
    }

    private void saveAppSession(String email, String ip) {

        AppSession appSession = new AppSession();
        appSession.setEmail(email);
        appSession.setLastTime(System.currentTimeMillis());
        appSession.setLastIP(ip);
        appSessionService.save(appSession);
    }
}
