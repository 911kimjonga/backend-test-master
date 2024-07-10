package kr.co.polycube.backendtest.domain.lotto.dao;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Lotto 매퍼 테스트
 *
 * @author 김종원
 * @version 1.0
 * @since 24. 7. 10. (수)
 */
@SpringBootTest
@Slf4j
class LottoMapperTest {

    @Autowired
    private LottoMapper lottoMapper;

    /**
     * Lotto 전체 조회 테스트 메소드
     */
    @Test
    void readAllTest() {
        // given
        // when
        List<Map<String, Object>> list = lottoMapper.readAll();
        // then
        log.info("list : {}", list);
        assertThat(list).isNotNull();
    }

    /**
     * 특정 ID로 Lotto 조회 테스트 메소드
     */
    @Test
    void readByIdTest() {
        // given
        long id = 1;
        // when
        Map<String, Object> lotto = lottoMapper.readById(id);
        // then
        log.info("list : {}", lotto);
        assertThat(lotto).isNotNull();
    }
}