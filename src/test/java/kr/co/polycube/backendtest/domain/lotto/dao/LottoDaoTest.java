package kr.co.polycube.backendtest.domain.lotto.dao;

import kr.co.polycube.backendtest.domain.lotto.dto.Lotto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Lotto DAO Test
 *
 * @author 김종원
 * @version 1.0
 * @since 24. 7. 9. (화)
 */
@SpringBootTest
@Slf4j
class LottoDaoTest {

    @Autowired
    private LottoDao lottoDao;

    /**
     * 로또 번호 생성 테스트 메소드
     */
    @Test
    void generateLottoNumbersTest() {
        // given
        // when
        Lotto lotto = lottoDao.generateNumbers();
        // then
        log.info("lotto : {}", lotto);
        assertThat(lotto).isNotNull();
    }
}