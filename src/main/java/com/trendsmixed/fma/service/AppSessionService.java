package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.AppSession;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.repository.AppSessionRepository;

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
}
