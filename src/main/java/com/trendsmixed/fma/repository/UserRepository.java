package com.trendsmixed.fma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trendsmixed.fma.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmail(String email);

	User findByEmailAndPassword(String email, String password);

}
