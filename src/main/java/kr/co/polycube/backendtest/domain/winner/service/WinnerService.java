package kr.co.polycube.backendtest.domain.winner.service;

import kr.co.polycube.backendtest.domain.winner.dto.Winner;

/**
 * Winner 서비스 인터페이스
 *
 * @author 김종원
 * @version 1.0
 * @since 24. 7. 10. (수)
 */
public interface WinnerService {

    /**
     * 당첨자 발생 시 당첨 정보 등록
     * 
     * @param winner Winner 객체
     */
    public void registWinner(Winner winner);

}
