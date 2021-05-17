package com.trendsmixed.fma.module.appsession;

import com.trendsmixed.fma.dao.AccessLog;
import com.trendsmixed.fma.entity.AppSession;
import lombok.AllArgsConstructor;
import net.logstash.logback.argument.StructuredArguments;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@AllArgsConstructor
@Service
public class AppSessionService {

    private final Logger LOGGER = LoggerFactory.getLogger(AppSessionService.class);

    private AppSessionRepository appSessionRepository;

    public List<AppSession> findAll() {
        return appSessionRepository.findAll();
    }

    public AppSession save(AppSession appSession) {
        return appSessionRepository.save(appSession);
    }

    public AppSession findOne(String email) {
        return appSessionRepository.findById(email).orElse(null);
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
        String servletPathRoot = (servletPathSplit.length > 1 ? servletPathSplit[1] : "");
        String pathInfo = request.getPathInfo();
        String queryString = request.getQueryString();

        LOGGER.info("Access Log", StructuredArguments.kv("request", new AccessLog(servletPath, servletPathRoot, methodString, queryString, remoteAddress, loginTimeMillsString)));

        if (servletPath.toLowerCase().contains("/login") || servletPath.toLowerCase().contains("/error") || methodString.equalsIgnoreCase("OPTIONS") || (servletPath.toLowerCase().contains("/users") && methodString.equalsIgnoreCase("POST"))) {
            return true;
        }

        if (loginTimeMillsString == null || loginTimeMillsString.equals("")) {
            System.out.println("loginTimeMillsString is blank ");
            return false;
        }

        AppSession appSession = findFirstByLoginTimeMills(Long.parseLong(loginTimeMillsString));

        if (appSession == null) {
            System.out.println("AppSession is null ");
            return false;
            // throw new Error("Please Login");
        }

        if (!appSession.getIp().equals(remoteAddress)) {
            deleteByLoginTimeMills(Long.parseLong(loginTimeMillsString));
            System.out.println("IP does not match");
            return false;
            // throw new Error("Please Login");
        }

        appSession.setLastTime(System.currentTimeMillis());
        save(appSession);
        return true;
    }
}