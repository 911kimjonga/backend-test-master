package kr.co.polycube.backendtest.web.common.Filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 필터 Configuration
 *
 * @author 김종원
 * @version 1.0
 * @since 24. 7. 9. (화)
 */
@Configuration
public class FilterConfig {

    /**
     * 필터 Bean 객체
     * @return 등록 Bean 객체
     */
    @Bean
    public FilterRegistrationBean<UsersPathFilter> specialCharacterFilter() {
        FilterRegistrationBean<UsersPathFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new UsersPathFilter());
        registrationBean.addUrlPatterns("/users/**");
        return registrationBean;
    }
}