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

	public void booo() {
		System.out.println("Booooooooooooooo");
		System.out.println(email);
		System.out.println(password);
		System.out.println(passwordAgain);
	}

	public boolean isValidToSave() {
		if (!password.equals(passwordAgain)) {
			return false;
		}

		if (!isAvailable()) {
			return false;
		}
		return true;
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
		return userService.findByEmailAndPassword(email,password) != null;
	}

}
