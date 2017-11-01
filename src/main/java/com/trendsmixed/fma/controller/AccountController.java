package com.trendsmixed.fma.controller;

import com.trendsmixed.fma.dao.UserDao;
import com.trendsmixed.fma.entity.AppSession;
import com.trendsmixed.fma.module.status.Status;
import com.trendsmixed.fma.module.team.Team;
import com.trendsmixed.fma.module.user.User;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.module.status.StatusService;
import com.trendsmixed.fma.module.team.TeamService;
import com.trendsmixed.fma.module.user.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/accounts")
public class AccountController {

    private final TeamService teamService;
    private final StatusService statusService;
    private final UserService userService;
    private final AppSessionService appSessionService;

    @PostMapping("/register")
    public boolean register(@RequestBody UserDao userDao, HttpServletRequest request) {
        userDao.setUserService(userService);
        User user = userDao.save();
        if (user != null) {
            saveAppSession(userDao.getEmail(), request.getRemoteAddr());
            return true;
        }
        return false;
    }

    @PostMapping("/login")
    public boolean login(@RequestBody UserDao userDao, HttpServletRequest request, HttpServletResponse response) {

        if (userDao.getEmail().equalsIgnoreCase("admin@trwlanka.com")
                && userDao.getPassword().equalsIgnoreCase("trwadmin")) {
            User admin = userService.findByEmail(userDao.getEmail());
            if (admin == null) {
                admin = new User();
                Team team = teamService.findByName("admin");
                if (team == null) {
                    team = new Team();
                    team.setName("admin");
                    team = teamService.save(team);
                }
                admin.setTeam(team);
                admin.setEmail(userDao.getEmail());
                admin.setPassword(userDao.getPassword());
                Status status = statusService.findByName("active");
                if (status == null) {
                    status = new Status();
                    status.setName("active");
                    status = statusService.save(status);
                }
                admin.setStatus(status);
                userService.save(admin);
            }

        }

        userDao.setUserService(userService);
        boolean authenticated = userDao.isAuthenticated();
        if (authenticated) {
            saveAppSession(userDao.getEmail(), request.getRemoteAddr());

            return authenticated;
        } else {
        }
        return authenticated;
    }

    @PostMapping("/logout")
    public void logout(@RequestBody UserDao userDao) {
        appSessionService.delete(userDao.getEmail());

        System.out.println(userDao.getEmail());
    }

    private void saveAppSession(String email, String ip) {

        AppSession appSession = new AppSession();
        appSession.setEmail(email);
        appSession.setLastTime(System.currentTimeMillis());
        appSession.setIp(ip);
        appSessionService.save(appSession);
    }
}
