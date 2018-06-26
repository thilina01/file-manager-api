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

    public void delete(String email) {
        appSessionRepository.delete(email);
    }

    public boolean isValid(HttpServletRequest request) {
        String email = request.getHeader("email");
        String loginTimeMillsString = request.getHeader("loginTimeMills");
        String uriString = request.getRequestURI();
        String methodString = request.getMethod();
        String remoteAddress = request.getRemoteAddr();

        System.out.println("Validating: " + email);
        System.out.println("RequestURI: " + uriString);
        System.out.println("Method: " + methodString);
        System.out.println("RemoteAddress: " + remoteAddress);
        System.out.println("loginTimeMills: " + loginTimeMillsString);

        if (uriString.toLowerCase().contains("/login") || methodString.equalsIgnoreCase("OPTIONS")) {
            return true;
        }

        if (email == null || email.equals("")) {
            System.out.println("Email is blank ");
            return false;
        }

        AppSession appSession = findOne(email);

        if (appSession == null) {
            System.out.println("AppSession is null ");
            return false;
            // throw new Error("Please Login");
        }

        if (!appSession.getIp().equals(remoteAddress)) {
            delete(email);
            System.out.println("IP does not match");
            return false;
            // throw new Error("Please Login");
        }

        appSession.setLastTime(System.currentTimeMillis());
        save(appSession);
        return true;
    }
}
