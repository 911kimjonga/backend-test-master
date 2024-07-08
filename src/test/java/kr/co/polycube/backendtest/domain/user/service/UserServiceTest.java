package kr.co.polycube.backendtest.domain.user.service;

import kr.co.polycube.backendtest.domain.user.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * User Service Test
 *
 * @author 김종원
 * @version 1.0
 * @since 24. 7. 8. (월)
 */
@SpringBootTest
@Slf4j
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    @Transactional
    void registerUserTest() {
        // given
        User user = User.builder()
                .id("jwk")
                .name("김종원")
                .build();
        // when
        userService.registerUser(user);
        // then
        log.info("id : {}", user.getId());
        assertThat(user.getId()).isNotNull();
    }

    @Test
    void readUserTest() {
        // given
        String id = "jw";
        // when
        User user = userService.readUser(id);
        // then
        log.info("id : {}, name : {}", user.getId(), user.getName());
        assertThat(user.getId()).isEqualTo(id);
    }

    @Test
    @Transactional
    void editUserTest() {
        // given
        User user = User.builder()
                .id("jw")
                .name("홍길동")
                .build();
        // when
        User editUser = userService.editUser(user);
        // then
        log.info("id : {}, name : {}", editUser.getId(), editUser.getName());
        assertThat(user.getId()).isNotNull();
    }
}