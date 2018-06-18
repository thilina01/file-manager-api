package com.trendsmixed.fma.module.team;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/teams")
public class TeamController {

    
    private final TeamService service;

    @JsonView(TeamView.AllAndMenuAll.class)
    @GetMapping
    public Iterable<Team> findAll() {
        return service.findAll();
    }

    @JsonView(TeamView.All.class)
    @GetMapping("/page")
    Page<Team> page(Pageable pageable) {
        return new Page<Team>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(TeamView.All.class)
    @PostMapping
    public Team save(@RequestBody Team team) {

        
        try {
            team = service.save(team);
            return team;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<Team> teams) {

        
        try {
            for (Team team : teams) {
                team.setName(team.getName().trim());
                Team existingTeam = service.findByName(team.getName());
                if (existingTeam != null) {
                    team.setId(existingTeam.getId());
                }
            }
            service.save(teams);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(TeamView.All.class)
    @GetMapping("/{id}")
    public Team findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.delete(id);

    }

    @JsonView(TeamView.All.class)
    @PutMapping("/{id}")
    public Team updateCustomer(@PathVariable int id, @RequestBody Team team) {
        
        team.setId(id);
        team = service.save(team);
        return team;
    }

}
