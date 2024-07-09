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
     * @param name User 이름
     */
    public void create(String name);

    /**
     * 가장 최근 등록한 User ID 조회
     *
     * @return User ID
     */
    public long readResentUser();

    /**
     * User 조회
     *
     * @param id User ID
     * @return User 객체
     */
    public User readById(long id);

    /**
     * User 수정
     * 
     * @param user User 객체
     */
    public void update(User user);

}
