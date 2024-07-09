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
        String name = "jw";
        // when
        userDao.create(name);
        // then
        log.info("name : {}", name);
        assertThat(name).isNotNull();
    }

    /**
     * 최근 등록한 User 조회 테스트 메소드
     */
    @Test
    void readResentUser() {
        // given
        // when
        long id = userDao.readResentUser();
        // then
        log.info("id : {}", id);
        assertThat(id).isNotZero();
    }

    /**
     * User 조회 테스트 메소드
     */
    @Test
    void readByIdTest() {
        // given
        long id = 1;
        // when
        User user = userDao.readById(id);
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
                .id(1)
                .name("kd")
                .build();
        // when
        userDao.update(user);
        // then
        log.info("id : {}, name : {}", user.getId(), user.getName());
        assertThat(user.getId()).isNotNull();
    }
}