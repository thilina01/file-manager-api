package com.trendsmixed.fma.module.user;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.status.Status;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.module.status.StatusService;
import com.trendsmixed.fma.utility.MailService;
import com.trendsmixed.fma.utility.Page;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {

    private final AppSessionService appSessionService;
    private final UserService service;
    private final MailService mailService;
    private final StatusService statusService;

    @JsonView(UserView.AllAndTeamAllAndStatusAll.class)
    @GetMapping
    public Iterable<User> findAll() {
        return service.findAll();
    }

    @JsonView(UserView.AllAndTeamAllAndStatusAll.class)
    @GetMapping("/page")
    Page<User> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(UserView.All.class)
    @PostMapping
    public User save(@RequestBody User user, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        try {
            boolean isActivation = false;
            boolean isNew = false;
            user.setId(user.getId() == null ? 0 : user.getId());
            int userId = user.getId();

            if (userId > 0) {
                User existingUser = service.findOne(userId);
                if (user.getPassword() == null) {
                    user.setPassword(existingUser.getPassword());
                }
                isActivation = existingUser.getStatus().getName().equalsIgnoreCase("inactive") && user.getStatus().getName().equalsIgnoreCase("active");
            } else {
                Status status = statusService.findByName("inactive");
                user.setStatus(status);
                isNew = true;
            }
            user = service.save(user);
            if (isNew) {
                notifyAdmin("New Account", " Name: " + user.getName() + "<br/>" + " Email: " + user.getEmail() + "<br/>");
                notifyUser(user.getEmail(), "New Account Created", "<b> Congratulations,  </b> <br/>  <br/> Your Account is creted successfully, Please wait, you will be informed once your account is activated.  <br/>  <br/>  Name: " + user.getName() + "<br/>" + " Email: " + user.getEmail() + "<br/>");
            }
            if (isActivation) {
                notifyUser(user.getEmail(), "Account Activated", "<b> Congratulations,  </b> <br/>  <br/> Your Account is now active, You may login using below link <br/>  <br/>  http://kpi.trwlanka.com/#/login <br/>");
            }
            return user;
        } catch (Throwable e) {
            e.printStackTrace();
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(UserView.AllAndTeamAllAndStatusAll.class)
    @GetMapping("/{id}")
    public User findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @JsonView(UserView.AllAndTeamAllAndStatusAll.class)
    @GetMapping("/own")
    public User own(@RequestHeader(value = "email", defaultValue = "") String email) {
        return service.findByEmail(email);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);
    }

    @PutMapping("/{id}")
    public User updateCustomer(@PathVariable int id, @RequestBody User user, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        user.setId(id);
        user = service.save(user);
        return user;
    }

    private void notifyAdmin(String subject, String message) {
        List<User> admins = service.findByTeamName("admin");
        List<String> emailList = new ArrayList<>();
        for (User admin : admins) {
            emailList.add(admin.getEmail());
        }
        if (!emailList.isEmpty()) {
            mailService.send(emailList, subject, message);
        }
    }

    private void notifyUser(String email, String subject, String message) {
        mailService.send(email, subject, message);
    }
}
