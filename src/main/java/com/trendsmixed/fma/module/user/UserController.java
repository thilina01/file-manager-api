package com.trendsmixed.fma.module.user;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.User;
import com.trendsmixed.fma.module.user.UserView;
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
@RequestMapping("/users")
public class UserController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private UserService userService;

    @JsonView(UserView.AllAndTeamAllAndStatusAll.class)
    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @JsonView(UserView.All.class)
    @PostMapping
    public User save(@RequestBody User user, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            int userId = user.getId();
            if (user.getPassword() == null && userId != 0) {
                User existingUser = userService.findOne(userId);
                user.setPassword(existingUser.getPassword());
            }
            user = userService.save(user);
            return user;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public User findOne(@PathVariable("id") int id) {
        return userService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        userService.delete(id);

    }

    @PutMapping("/{id}")
    public User updateCustomer(@PathVariable int id, @RequestBody User user, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        user.setId(id);
        user = userService.save(user);
        return user;
    }
}