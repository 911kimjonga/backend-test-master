package kr.co.polycube.backendtest.domain.lotto.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface LottoMapper {

    public List<Map<String, Object>> readAll();

    public Map<String, Object> readById(long id);

    public void createWinner(@Param("lottoId") long lottoId, @Param("rank") int rank);

}
