package kr.co.polycube.backendtest.domain.winner.service;

import kr.co.polycube.backendtest.domain.winner.dto.Winner;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

/**
 * Winner 서비스 테스트
 * 
 * @author 김종원
 * @version 1.0
 * @since 24. 7. 10. (수)
 */
@SpringBootTest
@Slf4j
class WinnerServiceTest {

    @Autowired
    private WinnerService winnerService;

    @Test
    @Transactional
    void registWinnerTest() {
        // given
        Winner winner = Winner.builder()
                .lottoId(1)
                .rank(1)
                .build();
        // when
        winnerService.registWinner(winner);
        // then
    }
}