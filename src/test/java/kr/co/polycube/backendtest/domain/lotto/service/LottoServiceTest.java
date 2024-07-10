package kr.co.polycube.backendtest.domain.lotto.service;

import kr.co.polycube.backendtest.domain.lotto.dto.Lotto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Lotto 서비스 테스트
 *
 * @author 김종원
 * @version 1.0
 * @since 24. 7. 9. (화)
 */
@SpringBootTest
@Slf4j
class LottoServiceTest {

    @Autowired
    private LottoService lottoService;

    /**
     * 로또 당첨번호 생성 서비스 테스트 메소드
     */
    @Test
    void lottoDrawTest() {
        // given
        // when
        Lotto lotto = lottoService.generateLotto();
        // then
        log.info("lotto : {}", lotto);
        assertThat(lotto).isNotNull();
    }

    @Test
    void getLottoAllTest() {
        // given
        // when
        List<Lotto> list = lottoService.getLottoAll();
        // then
        log.info("lottoList : {}", list);
        assertThat(list).isNotNull();
    }

    @Test
    void getLottoByIdTest() {
        // given
        long id = 1;
        // when
        Lotto lotto = lottoService.getLottoById(id);
        // then
        log.info("lotto : {}", lotto);
        assertThat(lotto).isNotNull();
    }
}