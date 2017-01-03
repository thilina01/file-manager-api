package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.Menu;
import com.trendsmixed.fma.entity.Team;
import com.trendsmixed.fma.entity.TeamMenu;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.repository.TeamMenuRepository;

@Service
public class TeamMenuService {

    @Autowired
    private TeamMenuRepository teamMenuRepository;

    public List<TeamMenu> findAll() {
        return teamMenuRepository.findAll();
    }

    public TeamMenu save(TeamMenu teamMenu) {
        return teamMenuRepository.save(teamMenu);
    }

    public List<TeamMenu> save(List<TeamMenu> teamMenus) {
        return teamMenuRepository.save(teamMenus);
    }

    public TeamMenu findOne(int id) {
        return teamMenuRepository.findOne(id);
    }

    public List<Menu> findTopMenuByTeam(Team team) {
        return teamMenuRepository.findTopMenuByTeam(team);
    }

    public void delete(int id) {
        teamMenuRepository.delete(id);
    }

    public void delete(List<TeamMenu> teamMenus) {
        teamMenuRepository.delete(teamMenus);
    }

    public TeamMenu findByTeamAndMenu(Team team, Menu menu) {
        return teamMenuRepository.findByTeamAndMenu(team, menu);
    }

    public List<TeamMenu> findByTeam(Team team) {
        return teamMenuRepository.findByTeam(team);
    }

}
