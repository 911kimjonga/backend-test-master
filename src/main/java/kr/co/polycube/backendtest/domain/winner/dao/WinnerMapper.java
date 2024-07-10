package kr.co.polycube.backendtest.domain.winner.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Winner 매퍼 인터페이스
 *
 * @author 김종원
 * @version 1.0
 * @since 24. 7. 10. (수)
 */
@Mapper
public interface WinnerMapper {

    /**
     * 당첨 시 Winner 생성
     *
     * @param lottoId 당첨된 Lotto ID
     * @param rank Lotto 당첨 등수
     */
    public void createWinner(@Param("lottoId") long lottoId, @Param("rank") int rank);

}
