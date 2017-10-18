package com.trendsmixed.fma.module.teammenu;

import com.trendsmixed.fma.module.team.Team;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.module.appsession.AppSessionService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController
@CrossOrigin
@RequestMapping("/teamMenus")
public class TeamMenuController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private TeamMenuService teamMenuService;

    @PutMapping
    public List<TeamMenu> saveMany(@RequestBody List<TeamMenu> teamMenus, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
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
