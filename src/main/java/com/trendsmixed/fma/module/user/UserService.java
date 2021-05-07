package com.trendsmixed.fma.module.user;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserService {

    private UserRepository repository;

    public Iterable<User> findAll() {
        return repository.findAll();
    }

    public Page<User> findAll(Pageable pageable) {
        return new Page<User>(repository.findAll(pageable));
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public User save(User user) {
        return repository.save(user);
    }

    public User findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public User findByEmail(String email) {
        return repository.findByEmail(email);

    }

    public User findByEmailAndPassword(String email, String password) {
        return repository.findByEmailAndPassword(email, password);

    }

    public Object findByEmailAndPasswordAndStatus(String email, String password, String status) {
        return repository.findByEmailAndPasswordAndStatus(email, password, status);
    }

    List<User> findByTeamName(String name) {
        return repository.findByTeamName(name);
    }
}
