package kr.co.polycube.backendtest.web.common.Filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.regex.Pattern;

/**
 * 특정 URI만 허용하는 필터 객체
 *
 * @author 김종원
 * @version 1.0
 * @since 24. 7. 9. (화)
 */
public class UsersPathFilter extends OncePerRequestFilter {

    private static final Pattern ALLOWED_PATTERN = Pattern.compile("[a-zA-Z0-9/?=&]");

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        if (!ALLOWED_PATTERN.matcher(requestURI).matches()) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "잘못된 URI 입니다.");
            return;
        }
        filterChain.doFilter(request, response);
    }

}
