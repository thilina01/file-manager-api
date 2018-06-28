package com.trendsmixed.fma;

import java.nio.charset.StandardCharsets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trendsmixed.fma.dao.AppError;
import com.trendsmixed.fma.module.appsession.AppSessionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

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

        if(handler instanceof ResourceHttpRequestHandler){
            ResourceHttpRequestHandler resourceHttpRequestHandler = (ResourceHttpRequestHandler) handler;
            System.out.println("================PRE 2=================");
            System.out.println("resourceHttpRequestHandler : "+resourceHttpRequestHandler);
            System.out.println("Class : ResourceHttpRequestHandler");
            System.out.println("================PRE 2 End=============");
            return false;
        } 

        if(handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            System.out.println("================PRE 1=================");
            // System.out.println("handlerMethod : "+handlerMethod);
            // System.out.println("getBean : " + handlerMethod.getBean());
            System.out.println("getBeanType : " + handlerMethod.getBeanType().getName());
            System.out.println("================PRE 1 End=============");
        }

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