package com.trendsmixed.fma.module.teammenu;

import com.trendsmixed.fma.module.team.Team;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/teamMenus")
public class TeamMenuController {

    
    private final TeamMenuService teamMenuService;

    @PutMapping
    public List<TeamMenu> saveMany(@RequestBody List<TeamMenu> teamMenus) {

        
        try {
            if (!teamMenus.isEmpty()) {
                Team team = teamMenus.get(0).getTeam();
                teamMenuService.delete(teamMenuService.findByTeam(team));
                teamMenus = teamMenuService.save(teamMenus);
            }
            return teamMenus;
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

}
