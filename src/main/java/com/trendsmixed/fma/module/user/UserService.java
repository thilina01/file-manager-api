package com.trendsmixed.fma.module.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.entity.User;
import com.trendsmixed.fma.module.user.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findOne(int id) {
        return userRepository.findOne(id);
    }

    public void delete(int id) {
        userRepository.delete(id);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);

    }

    public User findByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);

    }

    public Object findByEmailAndPasswordAndStatus(String email, String password, String status) {
        return userRepository.findByEmailAndPasswordAndStatus(email, password, status);
    }
}