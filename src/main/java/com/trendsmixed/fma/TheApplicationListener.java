package com.trendsmixed.fma;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 *
 * @author Thilina
 */
@Component
public class TheApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext applicationContext = ((ContextRefreshedEvent) event).getApplicationContext();
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = applicationContext.getBean(RequestMappingHandlerMapping.class).getHandlerMethods();
        // handlerMethods.forEach((requestMappingInfo, handlerMethod) -> {
        //     Class handlerClass =handlerMethod.getMethod().getDeclaringClass();
        //     if(handlerClass.getName().contains("omp")){
        //         System.out.println(requestMappingInfo);
        //         System.out.println(handlerMethod.getMethod());
        //         System.out.println(handlerMethod.getMethod().getDeclaringClass().getName());
        //         System.out.println("-----------------------------------------");
        //     }
        // });

        System.out.println(handlerMethods.size());
        System.out.println("To Be implemented : Request Mapping URL registory ");

    }
}
