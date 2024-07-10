package kr.co.polycube.backendtest.web.lotto.controller;

import kr.co.polycube.backendtest.domain.lotto.service.LottoService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Lotto 관련 요청 컨트롤러
 * 
 * @author 김종원
 * @version 1.0
 * @since 24. 7. 9. (화)
 */
@RestController
@RequestMapping("/lottos")
@RequiredArgsConstructor
public class LottoController {

    private final LottoService lottoService;

    /**
     * Lotto 생성 요청 처리
     * 
     * @param model 모델 객체
     * @return 반환 객체
     */
    @PostMapping("")
    public Map<String, Object> draw(Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("numbers", lottoService.generateLotto().getNumbers());

        return map;
    }
}
