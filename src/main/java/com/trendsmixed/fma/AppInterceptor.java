package com.trendsmixed.fma;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trendsmixed.fma.dao.AppError;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.module.menu.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;

@Component
public class AppInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private AppSessionService appSessionService;

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception)
            throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("================PRE=============");
        System.out.println(handler);
        boolean isValid = appSessionService.isValid(request);
        if(!isValid){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
            AppError appError = new AppError();
            appError.setTimestamp(System.currentTimeMillis());
            appError.setMessage("Please Login");
            appError.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            appError.setError("Invalid Session");
            appError.setPath(request.getRequestURI());
            response.getWriter().print(new ObjectMapper().writeValueAsString(appError));//write(jsonString);
        }
        return isValid;//appSessionService.isValid(request);
    }

}