package com.trendsmixed.fma.module.user;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.entity.Status;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.User;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.module.status.StatusService;
import com.trendsmixed.fma.utility.Page;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private UserService service;
    @Autowired
    private StatusService statusService;

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
        //appSessionService.isValid(email, request);
        try {
            user.setId(user.getId() == null ? 0 : user.getId());
            int userId = user.getId();

            if (userId > 0) {
                User existingUser = service.findOne(userId);
                if (user.getPassword() == null) {
                    user.setPassword(existingUser.getPassword());
                }
            } else {
                Status status = statusService.findByName("inactive");
                user.setStatus(status);
            }
            user = service.save(user);
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
}
