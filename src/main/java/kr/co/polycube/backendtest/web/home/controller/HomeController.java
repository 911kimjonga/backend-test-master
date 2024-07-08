package kr.co.polycube.backendtest.web.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 홈 컨트롤러
 *
 * @author 김종원
 * @version 1.0
 * @since 24. 7. 9. (화)
 */
@Controller
@RequestMapping("/")
public class HomeController {

    /**
     * 홈 요청 컨트롤러
     * 
     * @param model 모델 객체
     * @return 인덱스 뷰
     */
    @GetMapping("")
    public String home(Model model) {
        return "index";
    }

}
