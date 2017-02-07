package com.trendsmixed.fma.module.manpower;

import com.trendsmixed.fma.entity.Manpower;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.module.manpower.ManpowerRepository;

@Service
public class ManpowerService {

    @Autowired
    private ManpowerRepository manpowerRepository;

    public List<Manpower> findAll() {
        return manpowerRepository.findAll();
    }

    public Manpower save(Manpower manpower) {
        return manpowerRepository.save(manpower);
    }

    public void save(List<Manpower> manpowers) {
        manpowerRepository.save(manpowers);
    }

    public Manpower findOne(int id) {
        return manpowerRepository.findOne(id);
    }

    public void delete(int id) {
        manpowerRepository.delete(id);
    }

}
