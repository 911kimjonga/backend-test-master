package kr.co.polycube.backendtest.domain.lotto.service;

import kr.co.polycube.backendtest.domain.lotto.dto.Lotto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
class LottoServiceTest {

    @Autowired
    private LottoService lottoService;

    @Test
    void lottoDrawTest() {
        // given
        // when
        Lotto lotto = lottoService.generateLotto();
        // then
        log.info("lotto : {}", lotto);
        assertThat(lotto).isNotNull();
    }
}