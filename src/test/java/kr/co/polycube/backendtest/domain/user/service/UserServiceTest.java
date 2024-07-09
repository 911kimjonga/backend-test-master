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

    /**
     * User 등록 서비스 테스트 메소드
     */
    @Test
    @Transactional
    void registerUserTest() {
        // given
        String name = "aaa";
        // when
        long id = userService.registerUser(name);
        // then
        log.info("id : {}", id);
        assertThat(id).isNotZero();
    }

    /**
     * User 조회 서비스 테스트 메소드
     */
    @Test
    void readUserTest() {
        // given
        long id = 1;
        // when
        User user = userService.readUser(id);
        // then
        log.info("id : {}, name : {}", user.getId(), user.getName());
        assertThat(user.getId()).isEqualTo(id);
    }

    /**
     * User 수정 서비스 테스트 메소드
     */
    @Test
    @Transactional
    void editUserTest() {
        // given
        User user = User.builder()
                .id(1)
                .name("gildong")
                .build();
        // when
        User editUser = userService.editUser(user);
        // then
        log.info("id : {}, name : {}", editUser.getId(), editUser.getName());
        assertThat(editUser.getId()).isEqualTo(user.getId());
    }
}