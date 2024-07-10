package kr.co.polycube.backendtest.domain.lotto.service;

import kr.co.polycube.backendtest.domain.lotto.dto.Lotto;

import java.util.List;
import java.util.Map;

/**
 * Lotto 서비스 인터페이스
 * 
 * @author 김종원
 * @version 1.0
 * @since 24. 7. 9. (화)
 */
public interface LottoService {

    /**
     * Lotto 당첨 번호 생성
     *
     * @return Lotto 객체
     */
    public Lotto generateLotto();

    /**
     * 생성된 전체 Lotto 조회
     * 
     * @return 조회된 Lotto 번호 리스트
     */
    public List<Lotto> getLottoAll();

    /**
     * 특정 ID로 로또 조회
     * 
     * @param id 조회할 ID
     * @return 조회된 Lotto 번호
     */
    public Lotto getLottoById(long id);

}
