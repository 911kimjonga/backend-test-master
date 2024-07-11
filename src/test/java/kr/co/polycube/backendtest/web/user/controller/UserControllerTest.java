package kr.co.polycube.backendtest.web.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * User 컨트롤러 테스트
 * 
 * @author 김종원
 * @version 1.0
 * @since 24. 7. 9. (화)
 */
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * User 등록 요청 테스트 메소드
     *
     * @throws Exception 예외 객체
     */
    @Test
    @Transactional
    void registerTest() throws Exception {
        // given
        String name = "kim";
        // when
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/users")
                        .param("name", name))
        // then
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").isNumber());
    }

    /**
     * User 조회 요청 테스트 메소드
     *
     * @throws Exception 예외 객체
     */
    @Test
    void checkTest() throws Exception {
        // given
        long id = 1;
        // when
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/users/" + id))
        // then
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").isNumber())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").isNotEmpty());
    }

    /**
     * User 수정 요청 테스트 메소드
     *
     * @throws Exception 예외 객체
     */
    @Test
    @Transactional
    void editTest() throws Exception {
        // given
        long id = 1;
        String name = "kim";
        // when
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/users/" + id)
                        .param("name", name))
        // then
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").isNumber())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").isNotEmpty());
    }

    /**
     * URL 필터 적용 여부 요청 테스트
     * 
     * @throws Exception 예외 객체
     */
    @Test
    @Transactional
    void filterTest() throws Exception {
        // given
        long id = 1;
        String name = "test!!";
        // when
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/users/" + id)
                        .queryParam("name", name))
        // then
                .andExpect(status().isForbidden())
                .andExpect(status().reason("잘못된 URL 접근 입니다."));
    }

}