package kr.co.polycube.backendtest.domain.user.dao;

import kr.co.polycube.backendtest.domain.user.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * User Dao Test
 *
 * @author 김종원
 * @version 1.0
 * @since 24. 7. 8. (월)
 */
@SpringBootTest
@Slf4j
class UserDaoTest {

    @Autowired
    private UserDao userDao;

    /**
     * User 등록 테스트 메소드
     */
    @Test
    @Transactional
    void createTest() {
        // given
        User user = User.builder()
                .id("jwk")
                .name("김종원")
                .build();
        // when
        userDao.create(user);
        // then
        log.info("id : {}", user.getId());
        assertThat(user.getId()).isNotNull();
    }

    /**
     * User 조회 테스트 메소드
     */
    @Test
    void readTest() {
        // given
        String id = "jw";
        // when
        User user = userDao.read(id);
        // then
        log.info("id : {}, name : {}", user.getId(), user.getName());
        assertThat(user.getId()).isEqualTo(id);
    }

    /**
     * User 수정 테스트 메소드
     */
    @Test
    @Transactional
    void updateTest() {
        // given
        User user = User.builder()
                .id("jw")
                .name("홍길동")
                .build();
        // when
        userDao.update(user);
        // then
        log.info("id : {}, name : {}", user.getId(), user.getName());
        assertThat(user.getId()).isNotNull();
    }
}