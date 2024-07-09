package kr.co.polycube.backendtest.domain.lotto.service;

import kr.co.polycube.backendtest.domain.lotto.dao.LottoMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
class LottoBatchTest {

    @Autowired
    private LottoBatch lottoBatch;

    @Test
    @Transactional
    void checkWinnersTest() {
        lottoBatch.checkWinners();
        // 검증 로직 추가
    }
}