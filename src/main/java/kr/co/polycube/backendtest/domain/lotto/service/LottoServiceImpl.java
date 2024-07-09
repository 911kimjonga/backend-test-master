package kr.co.polycube.backendtest.domain.lotto.service;

import kr.co.polycube.backendtest.domain.lotto.dao.LottoDao;
import kr.co.polycube.backendtest.domain.lotto.dto.Lotto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Lotto Service 구현체
 *
 * @author 김종원
 * @version 1.0
 * @since 24. 7. 9. (화)
 */
@RequiredArgsConstructor
@Service
public class LottoServiceImpl implements LottoService {

    private final LottoDao lottoDao;

    /**
     * Lotto 당첨 번호 생성 구현 메소드
     * 
     * @return Lotto 객체
     */
    @Override
    public Lotto generateLotto() {
        return lottoDao.generateNumbers();
    }
}
