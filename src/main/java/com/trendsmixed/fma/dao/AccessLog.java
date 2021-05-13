package com.trendsmixed.fma.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AccessLog {

    private String servletPath, servletPathRoot, method, queryString, remoteAddress, loginTimeMills;

}
