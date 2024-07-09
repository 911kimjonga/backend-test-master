package kr.co.polycube.backendtest.domain.lotto.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Lotto 및 Winner 매퍼 인터페이스
 *
 * @author 김종원
 * @version 1.0
 * @since 24. 7. 9. (화)
 */
@Mapper
public interface LottoMapper {

    /**
     * Lotto 전체 조회
     * 
     * @return 조회된 Lotto 번호 리스트
     */
    public List<Map<String, Object>> readAll();

    /**
     * 특정 ID로 Lotto 조회
     * 
     * @param id 조회할 ID
     * @return 조회된 Lotto 번호
     */
    public Map<String, Object> readById(long id);

    /**
     * 당첨시 Winner 생성
     * 
     * @param lottoId 당첨된 Lotto ID
     * @param rank Lotto 당첨 등수
     */
    public void createWinner(@Param("lottoId") long lottoId, @Param("rank") int rank);

}
