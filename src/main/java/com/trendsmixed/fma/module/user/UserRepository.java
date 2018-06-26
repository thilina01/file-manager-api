package com.trendsmixed.fma.module.user;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
public interface UserRepository extends PagingAndSortingRepository<User, Integer> {

    User findByEmail(String email);

    User findByEmailAndPassword(String email, String password);

    List<User> findByTeamName(String name);

    User findByEmailAndPasswordAndStatus(String email, String password, String status);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.email, o.email)"
            + " FROM User o")
    List<Combo> getCombo();
}
