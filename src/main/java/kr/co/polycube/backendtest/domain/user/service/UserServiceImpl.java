package kr.co.polycube.backendtest.domain.user.service;

import kr.co.polycube.backendtest.domain.user.dao.UserMapper;
import kr.co.polycube.backendtest.domain.user.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * User 서비스 구현체
 *
 * @author 김종원
 * @version 1.0
 * @since 24. 7. 8. (월)
 */
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    /**
     * User 등록 구현 메소드
     *
     * @param name User 이름
     */
    @Override
    @Transactional
    public long registUser(String name) {
        userMapper.create(name);
        return userMapper.readResentUser();
    }

    /**
     * User 조회 구현 메소드
     *
     * @param id User ID
     * @return User 객체
     */
    @Override
    public User getUser(long id) {
        return userMapper.readById(id);
    }

    /**
     * User 수정 구현 메소드
     *
     * @param user User 수정 전 객체
     * @return User 수정 후 객체
     */
    @Override
    @Transactional
    public User editUser(User user) {
        userMapper.update(user);
        return userMapper.readById(user.getId());
    }

}
