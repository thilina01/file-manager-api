package com.trendsmixed.fma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.dao.UserDao;
import com.trendsmixed.fma.service.UserService;


@RestController
@CrossOrigin
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public boolean register(@RequestBody UserDao userDao) {
		userDao.setUserService(userService);
		return userDao.save();

	}
	@PostMapping("/login")
	public boolean login(@RequestBody UserDao userDao) {
		userDao.setUserService(userService);
		
		return userDao.isAuthenticated();

	}
}
