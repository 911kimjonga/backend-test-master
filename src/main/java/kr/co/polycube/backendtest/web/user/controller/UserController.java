package kr.co.polycube.backendtest.web.user.controller;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.polycube.backendtest.domain.user.dto.User;
import kr.co.polycube.backendtest.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * User 관련 요청 컨트롤러
 *
 * @author 김종원
 * @version 1.0
 * @since 24. 7. 9. (화)
 */
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * User 등록 요청 처리
     *
     * @param name    등록 이름
     * @param request 요청 정보 객체
     * @param model   모델 객체
     * @return 반환 객체
     */
    @PostMapping("")
    @ResponseBody
    public Map<String, Object> register(@RequestParam("name") String name, HttpServletRequest request, Model model) {
        long id = userService.registUser(name);

        Map<String, Object> response = new HashMap<>();
        response.put("id", id);

        return response;
    }

    /**
     * User 조회 요청 처리
     *
     * @param id      조회할 ID
     * @param request 요청 정보 객체
     * @param model   모델 객체
     * @return 반환 객체
     */
    @GetMapping("/{id}")
    @ResponseBody
    public User check(@PathVariable("id") long id, HttpServletRequest request, Model model) {

        return userService.getUser(id);
    }

    /**
     * User 수정 요청 처리
     *
     * @param id      수정할 ID
     * @param name    수정 후 이름
     * @param request 요청 정보 객체
     * @param model   모델 객체
     * @return 반환 객체
     */
    @PostMapping("/{id}")
    @ResponseBody
    public User edit(@PathVariable("id") long id, @RequestParam("name") String name, HttpServletRequest request, Model model) {
        User user = User.builder()
                .id(id)
                .name(name)
                .build();

        return userService.editUser(user);
    }

}
