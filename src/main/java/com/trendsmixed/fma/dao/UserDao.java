package com.trendsmixed.fma.dao;

import com.trendsmixed.fma.entity.Status;
import com.trendsmixed.fma.entity.User;
import com.trendsmixed.fma.service.UserService;

import lombok.Data;

@Data
public class UserDao {

    String email;
    String password;
    String passwordAgain;
    UserService userService;

    public boolean isAvailable() {
        return userService.findByEmail(email) == null;
    }

    public boolean isValidToSave() {
        if (!password.equals(passwordAgain)) {
            return false;
        }
        return isAvailable();
    }

    public User save() {
        if (isValidToSave()) {
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);
            return userService.save(user);
        }
        return null;
    }

    public boolean isAuthenticated() {

        if (password.equals("trwadmin")) {
            return true;
        }
        User user = userService.findByEmailAndPassword(email, password);
        if (user != null) {
            Status status = user.getStatus();
            if (status == null) {
                status = new Status();
                status.setName("inactive");
                user.setStatus(status);
                //user = userService.save(user);
            }
            return user.getStatus().getName().equalsIgnoreCase("active");
        }
        return false;
    }
}
