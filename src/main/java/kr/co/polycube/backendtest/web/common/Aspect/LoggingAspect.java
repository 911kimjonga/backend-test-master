package kr.co.polycube.backendtest.web.common.Aspect;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Logging Aspect
 * 
 * @author 김종원
 * @version 1.0
 * @since 24. 7. 9. (화)
 */
@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Before("execution(* kr.co.polycube.backendtest.web.user.controller.UserController.*(..))")
    public void logClientAgent(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        HttpServletRequest request = null;

        for (Object arg : args) {
            if (arg instanceof HttpServletRequest) {
                request = (HttpServletRequest) arg;
                break;
            }
        }

        if (request != null) {
            String clientAgent = request.getHeader("User-Agent");
            log.info("Client Agent: {}", clientAgent);
        } else {
            log.warn("HttpServletRequest 를 찾을 수 없습니다.");
        }
    }
}
