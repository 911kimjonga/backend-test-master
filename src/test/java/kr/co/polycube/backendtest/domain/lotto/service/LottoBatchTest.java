package kr.co.polycube.backendtest.domain.lotto.service;

import kr.co.polycube.backendtest.domain.lotto.dao.LottoMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Lotto Batch Test
 *
 * @author 김종원
 * @version 1.0
 * @since 24. 7. 9. (화)
 */
@SpringBootTest
@Slf4j
class LottoBatchTest {

    @Autowired
    private LottoBatch lottoBatch;

    /**
     * 로또 등수 매기기 자동 실행 테스트 메소드
     */
    @Test
    @Transactional
    void checkWinnersTest() {
        // given
        // when
        lottoBatch.checkWinners();
        // then
    }
}