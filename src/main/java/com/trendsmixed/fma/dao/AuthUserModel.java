package com.trendsmixed.fma.dao;

import lombok.Data;

@Data
public class AuthUserModel {
    private String email, password, passwordAgain;
}
