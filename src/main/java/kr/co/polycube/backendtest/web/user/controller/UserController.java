package kr.co.polycube.backendtest.web.user.controller;

import kr.co.polycube.backendtest.domain.user.dto.User;
import kr.co.polycube.backendtest.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
     * @param user User 객체
     * @param model 모델 객체
     * @return 반환 값
     */
    @PostMapping("")
    @ResponseBody
    public String register(@ModelAttribute User user, Model model) {
        userService.registerUser(user);

        return user.getId();
    }

    /**
     * User 조회 요청 처리
     * 
     * @param id 조회할 User ID
     * @param model 모델 객체
     * @return 반환 값
     */
    @GetMapping("/{id}")
    @ResponseBody
    public User check(@PathVariable String id, Model model) {
        return userService.readUser(id);
    }

    /**
     * User 정보 수정 요청 처리
     * 
     * @param id 수정할 User ID
     * @param name 수정 후 User 이름
     * @param model 모델 객체
     * @return 반환 값
     */
    @PostMapping("/{id}")
    @ResponseBody
    public User edit(@PathVariable String id, @RequestParam String name, Model model) {

        User user = User.builder()
                .id(id)
                .name(name)
                .build();

        return userService.editUser(user);
    }

}
