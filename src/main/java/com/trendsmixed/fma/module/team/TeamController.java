package com.trendsmixed.fma.module.team;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.Team;
import com.trendsmixed.fma.module.team.TeamView;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController
@CrossOrigin
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private TeamService teamService;

    @JsonView(TeamView.AllAndMenuAll.class)
    @GetMapping
    public List<Team> findAll() {
        return teamService.findAll();
    }

    @PostMapping
    public Team save(@RequestBody Team team, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            team = teamService.save(team);
            return team;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<Team> teams, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            for (Team team : teams) {
                team.setName(team.getName().trim());
                Team existingTeam = teamService.findByName(team.getName());
                if (existingTeam != null) {
                    team.setId(existingTeam.getId());
                }
            }
            teamService.save(teams);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Team findOne(@PathVariable("id") int id) {
        return teamService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        teamService.delete(id);

    }

    @PutMapping("/{id}")
    public Team updateCustomer(@PathVariable int id, @RequestBody Team team, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        team.setId(id);
        team = teamService.save(team);
        return team;
    }

}
