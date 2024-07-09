package kr.co.polycube.backendtest.web.lotto.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Lotto Controller Test
 *
 * @author 김종원
 * @version 1.0
 * @since 24. 7. 9. (화)
 */
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
class LottoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Lotto 생성 컨트롤러 테스트 메소드
     *
     * @throws Exception 예외
     */
    @Test
    void drawTest() throws Exception {
        // given
        // when
        mockMvc.perform(MockMvcRequestBuilders
                .post("/lottos"))
        // then
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.numbers").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.numbers").isNotEmpty());
    }
}