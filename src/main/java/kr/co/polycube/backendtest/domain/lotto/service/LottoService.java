package kr.co.polycube.backendtest.domain.lotto.service;

import kr.co.polycube.backendtest.domain.lotto.dto.Lotto;

/**
 * Lotto Service 인터페이스
 * 
 * @author 김종원
 * @version 1.0
 * @since 24. 7. 9. (화)
 */
public interface LottoService {

    /**
     * Lotto 생성
     *
     * @return Lotto 객체
     */
    public Lotto generateLotto();

}
