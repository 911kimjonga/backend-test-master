package kr.co.polycube.backendtest.domain.user.service;

import kr.co.polycube.backendtest.domain.user.dto.User;

/**
 * User 서비스 인터페이스
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
    public long registUser(String name);

    /**
     * User 조회
     *
     * @param id User ID
     * @return User 객체
     */
    public User getUser(long id);

    /**
     * User 수정
     *
     * @param user User 수정 전 객체
     * @return User 수정 후 객체
     */
    public User editUser(User user);

}
