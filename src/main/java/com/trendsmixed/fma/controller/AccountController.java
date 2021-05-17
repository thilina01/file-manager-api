package com.trendsmixed.fma.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trendsmixed.fma.dao.AuthUserModel;
import com.trendsmixed.fma.dao.UserDao;
import com.trendsmixed.fma.entity.AppSession;
import com.trendsmixed.fma.log.LogExecution;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.module.user.UserService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/accounts")
public class AccountController {

    private final UserService userService;
    private final AppSessionService appSessionService;

    @LogExecution
    @PostMapping("/register")
    public AppSession register(@RequestBody AuthUserModel authUserModel, HttpServletRequest request) {
        if (new UserDao(authUserModel).save(userService) != null) {
            return saveAppSession(authUserModel.getEmail(), request.getRemoteAddr());
        }
        return null;
    }

    @LogExecution
    @PostMapping("/login")
    public AppSession login(@RequestBody AuthUserModel authUserModel, HttpServletRequest request, HttpServletResponse response) {

        if (new UserDao(authUserModel).isAuthenticated(userService)) {
            AppSession appSession = saveAppSession(authUserModel.getEmail(), request.getRemoteAddr());
            Cookie cookie = new Cookie("loginTimeMills", appSession.getLoginTimeMills()+"");    
            // StringBuffer requestURL = request.getRequestURL();            
            // String domain =requestURL.substring(requestURL.indexOf(":")+3, requestURL.lastIndexOf(":"));
            // cookie.setDomain(domain);
            // cookie.setPath("/");
            response.addCookie(cookie);
            //response.addHeader("Set-Cookie","loginTimeMills="+appSession.getLoginTimeMills());
            return appSession;
        } 
        return null;
    }

    @LogExecution
    @GetMapping("/logout")
    public long logout( @RequestHeader(value = "loginTimeMills", defaultValue = "") long loginTimeMills) {
        return appSessionService.deleteByLoginTimeMills(loginTimeMills);
    }

    private AppSession saveAppSession(String email, String ip) {

        AppSession appSession = new AppSession();
        appSession.setEmail(email);
        appSession.setLoginTimeMills(System.currentTimeMillis());
        appSession.setLastTime(System.currentTimeMillis());
        appSession.setIp(ip);
        return appSessionService.save(appSession);
    }
}
