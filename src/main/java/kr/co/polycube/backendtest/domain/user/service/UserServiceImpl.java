package kr.co.polycube.backendtest.domain.user.service;

import kr.co.polycube.backendtest.domain.user.dao.UserDao;
import kr.co.polycube.backendtest.domain.user.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * User Service 구현체
 *
 * @author 김종원
 * @version 1.0
 * @since 24. 7. 8. (월)
 */
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    /**
     * User 등록 구현 메소드
     *
     * @param user User 객체
     * @return User ID
     */
    @Override
    public String registerUser(User user) {
        userDao.create(user);
        return user.getId();
    }

    /**
     * User 조회 구현 메소드
     *
     * @param id User ID
     * @return User 객체
     */
    @Override
    public User readUser(String id) {
        return userDao.read(id);
    }

    /**
     * User 수정 구현 메소드
     *
     * @param user User 수정 전 객체
     * @return User 수정 후 객체
     */
    @Override
    public User editUser(User user) {
        userDao.update(user);
        return userDao.read(user.getId());
    }

}
