package com.trendsmixed.fma.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

import static net.logstash.logback.marker.Markers.appendEntries;

@Aspect
@Component
public class LogExecutionAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogExecutionAspect.class);

    @Around("@annotation(LogExecution)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;

        Map<String, Object> m = new HashMap<String, Object>();
        m.put("signature", joinPoint.getSignature().toString());
        m.put("executionTime", executionTime);
        Map<String, Object> params = new HashMap<String, Object>();
        int i = 1;
        for (Object o : joinPoint.getArgs()) {
            if (!(o instanceof HttpServletRequest || o instanceof HttpServletResponse)) {
                params.put("param" + i, o);
            }
            i++;
        }
        m.put("param", params);
        LOGGER.info(appendEntries(m), joinPoint.getSignature().getName());
        return proceed;
    }
}
