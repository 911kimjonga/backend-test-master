package kr.co.polycube.backendtest.web.common.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.regex.Pattern;

/**
 * 특정 URL만 허용하는 필터 객체
 *
 * @author 김종원
 * @version 1.0
 * @since 24. 7. 9. (화)
 */
public class PathFilter extends OncePerRequestFilter {

    /**
     * 허용하는 URL 패턴
     */
    private static final Pattern DISALLOWED_PATTERN = Pattern.compile("[^a-zA-Z0-9/?=&]");

    /**
     * 필터 적용 메소드
     * 
     * @param request 리퀘스트 객체
     * @param response 리스폰스 객체
     * @param filterChain 필터 체인
     * @throws ServletException 서블릿 예외
     * @throws IOException 입출력 예외
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String queryString = request.getQueryString();

        if (DISALLOWED_PATTERN.matcher(requestURI).find() ||
                (queryString != null && DISALLOWED_PATTERN.matcher(queryString).find())) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "잘못된 URL 접근 입니다.");
            return;
        }
        
        filterChain.doFilter(request, response);
    }

}
