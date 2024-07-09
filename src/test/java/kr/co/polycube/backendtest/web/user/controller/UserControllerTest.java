package kr.co.polycube.backendtest.web.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * User Controller Test
 *
 * @author VJ특공대 김종원
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
     * User 등록 컨트롤러 테스트 메소드
     * 
     * @throws Exception 예외
     */
    @Test
    @Transactional
    void registerTest() throws Exception {
        // given
        String id = "ga";
        String name = "nadara";
        // when
        mockMvc.perform(MockMvcRequestBuilders
                .post("/users")
                .param("id", id)
                .param("name", name))
        // then
                .andExpect(status().isOk())
                .andExpect(content().string(id));
    }

    /**
     * User 조회 컨트롤러 테스트 메소드
     * 
     * @throws Exception 예외
     */
    @Test
    @Transactional
    void checkTest() throws Exception {
        // given
        String id = "ga";
        String name = "nadara";
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/users")
                        .param("id", id)
                        .param("name", name))
                .andExpect(status().isOk());
        // when
        mockMvc.perform(MockMvcRequestBuilders
                .get("/users/"+id))
                // then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.name").value(name));
    }

    /**
     * User 수정 컨트롤러 테스트 메소드
     * 
     * @throws Exception 예외
     */
    @Test
    @Transactional
    void editTest() throws Exception {
        // given
        String id = "ga";
        String name = "nadara";
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/users")
                        .param("id", id)
                        .param("name", name))
                .andExpect(status().isOk());
        String editName = "darama";
        // when
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/users/" + id)
                        .param("name", editName))
        // then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.name").value(editName));
    }

    /**
     * URL 필터 테스트 메소드
     * 
     * @throws Exception 예외
     */
    @Test
    @Transactional
    void filterTest() throws Exception {
        // given
        String id = "ga";
        String name = "nadara";
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/users")
                        .param("id", id)
                        .param("name", name))
                .andExpect(status().isOk());
        String editName = "test!!";
        // when
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/users/" + id)
                        .queryParam("name", editName))
                // then
                .andExpect(status().isForbidden())
                .andExpect(status().reason("잘못된 URL 접근 입니다."));
    }
}