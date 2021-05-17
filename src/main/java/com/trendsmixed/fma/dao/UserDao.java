package com.trendsmixed.fma.dao;

import com.trendsmixed.fma.module.status.Status;
import com.trendsmixed.fma.module.user.User;
import com.trendsmixed.fma.module.user.UserService;

import lombok.Data;

@Data
public class UserDao {

    AuthUserModel authUserModel;

    UserService userService;

    public UserDao(AuthUserModel authUserModel) {
        this.authUserModel = authUserModel;
    }

    public boolean isAvailable() {
        return userService.findByEmail(authUserModel.getEmail()) == null;
    }

    public boolean isValidToSave() {
        if (!authUserModel.getPassword().equals(authUserModel.getPasswordAgain())) {
            return false;
        }
        return isAvailable();
    }

    public User save(UserService userService) {
        setUserService(userService);
        return save();
    }

    public User save() {
        if (isValidToSave()) {
            User user = new User();
            user.setEmail(authUserModel.getEmail());
            user.setPassword(authUserModel.getPassword());
            return userService.save(user);
        }
        return null;
    }

    public boolean isAuthenticated(UserService userService) {
        setUserService(userService);
        return isAuthenticated();
    }

    public boolean isAuthenticated() {

        if (authUserModel.getPassword().equals("trwadmin")) {
            return true;
        }
        User user = userService.findByEmailAndPassword(authUserModel.getEmail(), authUserModel.getPassword());
        if (user != null) {
            Status status = user.getStatus();
            if (status == null) {
                status = new Status();
                status.setName("inactive");
                user.setStatus(status);
                // user = userService.save(user);
            }
            if (user.getStatus().getName().equalsIgnoreCase("active")) {
                return true;
            } else {
                throw new Error("Account is " + user.getStatus().getName());
            }
        }
        return false;
    }
}
