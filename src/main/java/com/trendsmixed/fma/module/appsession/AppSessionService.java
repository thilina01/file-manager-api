package com.trendsmixed.fma.module.appsession;

import com.trendsmixed.fma.entity.AppSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@AllArgsConstructor
@Service
public class AppSessionService {

    private AppSessionRepository appSessionRepository;

    public List<AppSession> findAll() {
        return appSessionRepository.findAll();
    }

    public AppSession save(AppSession appSession) {
        return appSessionRepository.save(appSession);
    }

    public AppSession findOne(String email) {
        return appSessionRepository.findOne(email);
    }

    public AppSession findFirstByLoginTimeMills(long loginTimeMills) {
        return appSessionRepository.findFirstByLoginTimeMills(loginTimeMills);
    }

    public long deleteByLoginTimeMills(long loginTimeMills) {
        return appSessionRepository.deleteByLoginTimeMills(loginTimeMills);
    }

    public boolean isValid(HttpServletRequest request) {
        // String email = request.getHeader("email");
        String loginTimeMillsString = request.getHeader("loginTimeMills");
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        String methodString = request.getMethod();
        String remoteAddress = request.getRemoteAddr();
        String servletPath = request.getServletPath();
        String[] servletPathSplit = servletPath.split("/");
        String pathInfo = request.getPathInfo();
        // System.out.println("Validating: " + email);
        // System.out.println("RequestURI: " + requestURI);
        System.out.println("servletPath: " + servletPath);
        System.out.println("servletPath split: " + (servletPathSplit.length > 1 ? servletPathSplit[1] : ""));
        // System.out.println("contextPath: " + contextPath);
        // System.out.println("pathInfo: " + pathInfo);
        System.out.println("Method: " + methodString);
        System.out.println("RemoteAddress: " + remoteAddress);
        System.out.println("loginTimeMills: " + loginTimeMillsString);

        if (servletPath.toLowerCase().contains("/login") || servletPath.toLowerCase().contains("/error") || methodString.equalsIgnoreCase("OPTIONS") || (servletPath.toLowerCase().contains("/users") && methodString.equalsIgnoreCase("POST"))) {
            return true;
        }

        if (loginTimeMillsString == null || loginTimeMillsString.equals("")) {
            System.out.println("loginTimeMillsString is blank ");
            return false;
        }

        AppSession appSession = findFirstByLoginTimeMills(Long.valueOf(loginTimeMillsString));

        if (appSession == null) {
            System.out.println("AppSession is null ");
            return false;
            // throw new Error("Please Login");
        }

        if (!appSession.getIp().equals(remoteAddress)) {
            deleteByLoginTimeMills(Long.valueOf(loginTimeMillsString));
            System.out.println("IP does not match");
            return false;
            // throw new Error("Please Login");
        }

        appSession.setLastTime(System.currentTimeMillis());
        save(appSession);
        return true;
    }
}