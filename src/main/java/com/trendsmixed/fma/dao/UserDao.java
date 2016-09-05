package com.trendsmixed.fma.dao;

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

    public boolean save() {
        if (isValidToSave()) {
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);
            userService.save(user);
            return true;
        }
        return false;
    }

    public boolean isAuthenticated() {
        return userService.findByEmailAndPassword(email, password) != null;
    }

}
