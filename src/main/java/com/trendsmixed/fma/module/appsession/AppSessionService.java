package com.trendsmixed.fma.module.appsession;

import com.trendsmixed.fma.entity.AppSession;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.module.appsession.AppSessionRepository;
import javax.servlet.http.HttpServletRequest;

@Service
public class AppSessionService {

    @Autowired
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

    public boolean isValid(String email, HttpServletRequest request) {
        AppSession appSession = findOne(email);
        if (appSession == null) {
            throw new Error("Please Login");
        }
        if (!appSession.getIp().equals(request.getRemoteAddr())) {
            delete(email);
            throw new Error("Please Login");
        }
        /*
        if (appSession.getLastTime() < (System.currentTimeMillis() - (1000 * 60 * 10))) {
            delete(email);
            throw new Error("Please Login Again");
        }*/
        appSession.setLastTime(System.currentTimeMillis());
        save(appSession);
        return true;
    }
}
