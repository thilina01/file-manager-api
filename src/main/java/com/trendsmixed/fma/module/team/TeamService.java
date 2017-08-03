package com.trendsmixed.fma.module.team;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class TeamService {

    @Autowired
    private TeamRepository repository;

    public Iterable<Team> findAll() {
        return repository.findAll();
    }
    
    public Page<Team> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
    
public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public Team save(Team team) {
        return repository.save(team);
    }

    public Iterable<Team> save(List<Team> teams) {
        return repository.save(teams);
    }

    public Team findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public Team findByName(String name) {
        return repository.findByName(name);

    }

}
