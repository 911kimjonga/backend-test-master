package kr.co.polycube.backendtest.web.winner.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

/**
 * Winner Batch 테스트
 *
 * @author 김종원
 * @version 1.0
 * @since 24. 7. 10. (수)
 */
@SpringBootTest
@Slf4j
class WinnerBatchTest {

    @Autowired
    private WinnerBatch WinnerBatch;

    /**
     * 로또 등수 매기기 자동 실행 테스트 메소드
     */
    @Test
    @Transactional
    void checkWinnersTest() {
        // given
        // when
        WinnerBatch.checkWinners();
        // then
    }
}