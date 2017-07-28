package com.trendsmixed.fma.module.team;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.module.team.TeamRepository;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    public Team save(Team team) {
        return teamRepository.save(team);
    }

    public List<Team> save(List<Team> teams) {
        return teamRepository.save(teams);
    }

    public Team findOne(int id) {
        return teamRepository.findOne(id);
    }

    public void delete(int id) {
        teamRepository.delete(id);
    }

    public Team findByName(String name) {
        return teamRepository.findByName(name);

    }

}
