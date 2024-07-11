package kr.co.polycube.backendtest.domain.winner.dao;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

/**
 * Winner 매퍼 테스트
 *
 * @author 김종원
 * @version 1.0
 * @since 24. 7. 10. (수)
 */
@SpringBootTest
@Slf4j
class WinnerMapperTest {

    @Autowired
    private WinnerMapper winnerMapper;

    @Test
    @Transactional
    void createWinnerTest() {
        // given
        long lottoId = 1;
        int rank = 1;
        // when
        winnerMapper.createWinner(lottoId, rank);
        // then
    }
}