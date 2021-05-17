package com.trendsmixed.fma.module.teammenu;

import com.trendsmixed.fma.module.menu.Menu;
import com.trendsmixed.fma.module.team.Team;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TeamMenuService {

    private TeamMenuRepository teamMenuRepository;

    public List<TeamMenu> findAll() {
        return teamMenuRepository.findAll();
    }

    public TeamMenu save(TeamMenu teamMenu) {
        return teamMenuRepository.save(teamMenu);
    }

    public List<TeamMenu> save(List<TeamMenu> teamMenus) {
        return teamMenuRepository.saveAll(teamMenus);
    }

    public TeamMenu findById(int id) {
        return teamMenuRepository.findById(id).orElse(null);
    }

    public List<Menu> findTopMenuByTeam(Team team) {
        return teamMenuRepository.findTopMenuByTeam(team);
    }

    public void deleteById(int id) {
        teamMenuRepository.deleteById(id);
    }

    public void delete(List<TeamMenu> teamMenus) {
        teamMenuRepository.deleteAll(teamMenus);
    }

    public TeamMenu findByTeamAndMenu(Team team, Menu menu) {
        return teamMenuRepository.findByTeamAndMenu(team, menu);
    }

    public List<TeamMenu> findByTeam(Team team) {
        return teamMenuRepository.findByTeam(team);
    }

}
