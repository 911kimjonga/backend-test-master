package kr.co.polycube.backendtest.domain.user.dao;

import kr.co.polycube.backendtest.domain.user.dto.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * User DAO 인터페이스
 *
 * @author 김종원
 * @version 1.0
 * @since 24. 7. 8. (월)
 */
@Mapper
public interface UserDao {

    /**
     * User 등록
     *
     * @param user User 객체
     */
    public void create(User user);

    /**
     * User 조회
     *
     * @param id User ID
     * @return User 객체
     */
    public User read(String id);

    /**
     * User 수정
     *
     * @param id User ID
     */
    public void update(User user);

}
