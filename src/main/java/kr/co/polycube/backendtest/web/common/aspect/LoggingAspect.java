package kr.co.polycube.backendtest.web.common.aspect;

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

    /**
     * User 컨트롤러 요청 시 Console에 Client Agent를 출력하는 Aspect
     *
     * @param joinPoint 클라이언트 호출 비즈니스 메소드
     */
    @Before("execution(* kr.co.polycube.backendtest.web.user.controller.UserController.*(..))")
    public void loggingClientAgent(JoinPoint joinPoint) {
        // 컨트롤러 요청 시 메소드 확인
        String methodName = joinPoint.getSignature().getName();
        log.info("요청 메소드 : {}", methodName);
        
        // 요청 정보 받기
        Object[] objects = joinPoint.getArgs();
        HttpServletRequest request = null;

        for (Object object : objects) {
            if (object instanceof HttpServletRequest) {
                request = (HttpServletRequest) object;
                break;
            }
        }
        
        // 요청 정보에서 User-Agent 정보 받기
        if (request != null) {
            String clientAgent = request.getHeader("User-Agent");
            log.info("Client Agent : {}", clientAgent);
        } else {
            log.warn("HttpServletRequest 를 찾을 수 없습니다.");
        }
    }
}
