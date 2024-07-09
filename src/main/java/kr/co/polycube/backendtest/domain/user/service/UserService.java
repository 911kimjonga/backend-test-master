package kr.co.polycube.backendtest.domain.user.service;

import kr.co.polycube.backendtest.domain.user.dto.User;

/**
 * User Service 인터페이스
 *
 * @author 김종원
 * @version 1.0
 * @since 24. 7. 8. (월)
 */
public interface UserService {

    /**
     * User 등록
     *
     * @param name User 이름
     */
    public long registerUser(String name);

    /**
     * User 조회
     *
     * @param id User ID
     * @return User 객체
     */
    public User readUser(long id);

    /**
     * User 수정
     *
     * @param user User 수정 전 객체
     * @return User 수정 후 객체
     */
    public User editUser(User user);

}
