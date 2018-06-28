package com.trendsmixed.fma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.MappedInterceptor;

@Configuration
public class AppConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private AppInterceptor appInterceptor;

    // @Override
    // public void addInterceptors(InterceptorRegistry registry) {
    // registry.addInterceptor(appInterceptor).addPathPatterns("/**");
    // }

    @Bean
    public MappedInterceptor mappedInterceptor() {
        return new MappedInterceptor(new String[] { "/**" }, appInterceptor);
    }
}