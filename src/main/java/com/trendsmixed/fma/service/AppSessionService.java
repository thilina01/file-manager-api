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

    public AppSession findOne(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
