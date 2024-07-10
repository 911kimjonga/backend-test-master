package kr.co.polycube.backendtest.web.winner.controller;

import kr.co.polycube.backendtest.domain.lotto.dto.Lotto;
import kr.co.polycube.backendtest.domain.lotto.service.LottoService;
import kr.co.polycube.backendtest.domain.winner.dto.Winner;
import kr.co.polycube.backendtest.domain.winner.service.WinnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 로또 등수 매기기 자동 실행 컴포넌트 
 * 
 * @author 김종원
 * @version 1.0
 * @since 24. 7. 9. (화)
 */
@Component
@RequiredArgsConstructor
public class WinnerBatch {

    private final LottoService lottoService;
    private final WinnerService winnerService;

    /**
     * 로또 등수 매기기 자동 실행 메소드
     */
    @Scheduled(cron = "0 0 0 * * SUN") // 매주 일요일 0시에 실행
    public void checkWinners() {
        // 로또 전체 조회
        List<Lotto> lottoList = lottoService.getLottoAll();

        // 로또 당첨 번호 조회
        Lotto generateNumbers = lottoService.generateLotto();
        List<Integer> lottoNumbers = generateNumbers.getNumbers();

        // 로또 전체에서 하나의 행씩 당첨번호와 비교
        for (Lotto lotto : lottoList) {
            // 로또 번호 맞은 갯수 비교
            int correctNumbers = countCorrect(lottoNumbers, lotto.getNumbers());

            // 로또 등수
            int rank = lottoRank(correctNumbers);

            // 담첨 정보 Winner 객체에 담기
            Winner winner = Winner.builder()
                    .lottoId(lotto.getId())
                    .rank(rank)
                    .build();
            
            // 당첨자일 경우 Winner 객체 데이터베이스에 등록
            if (rank > 0) {
                winnerService.registWinner(winner);
            }
        }
    }

    /**
     * 로또 번호 맞은 갯수 세는 메소드
     * 
     * @param lottoNumbers 로또 당첨 번호
     * @param tableNumbers 비교할 번호
     * @return 맞은 갯수
     */
    private int countCorrect(List<Integer> lottoNumbers, List<Integer> tableNumbers) {
        int count = 0;
        for (int num : tableNumbers) {
            if (lottoNumbers.contains(num)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 로또 맞은 번호 수에 따라 등수 매기는 메소드
     * 
     * @param correctNumbers 번호 맞은 갯수
     * @return 등수
     */
    private int lottoRank(int correctNumbers) {
        switch (correctNumbers) {
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 0;
        }
    }

}
