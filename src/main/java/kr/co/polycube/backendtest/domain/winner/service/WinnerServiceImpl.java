package kr.co.polycube.backendtest.domain.winner.service;

import kr.co.polycube.backendtest.domain.winner.dao.WinnerMapper;
import kr.co.polycube.backendtest.domain.winner.dto.Winner;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Winner 서비스 구현체
 * 
 * @author 김종원
 * @version 1.0
 * @since 24. 7. 10. (수)
 */
@Service
@RequiredArgsConstructor
public class WinnerServiceImpl implements WinnerService {

    private final WinnerMapper winnerMapper;

    /**
     * 당첨자 발생 시 등록 구현 메소드
     * 
     * @param winner Winner 객체
     */
    @Override
    @Transactional
    public void registWinner(Winner winner) {

        winnerMapper.createWinner(winner.getLottoId(), winner.getRank());
    }
}
