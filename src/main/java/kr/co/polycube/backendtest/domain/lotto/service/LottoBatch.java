package kr.co.polycube.backendtest.domain.lotto.service;

import kr.co.polycube.backendtest.domain.lotto.dao.LottoDao;
import kr.co.polycube.backendtest.domain.lotto.dao.LottoMapper;
import kr.co.polycube.backendtest.domain.lotto.dto.Lotto;
import lombok.*;
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
public class LottoBatch {

    private final LottoMapper lottoMapper;
    private final LottoDao lottoDao;

    /**
     * 로또 등수 매기기 자동 실행 메소드
     */
    @Scheduled(cron = "0 0 0 * * SUN") // 매주 일요일 0시에 실행
    public void checkWinners() {
        // 로또 전체 조회
        List<Map<String, Object>> lottoTable = lottoMapper.readAll();

        // 로또 당첨 번호 조회
        Lotto generateNumbers = lottoDao.generateNumbers();
        List<Integer> lottoNumbers = generateNumbers.getNumbers();

        // 로또 전체에서 하나의 행씩 당첨번호와 비교
        for (Map<String, Object> lotto : lottoTable) {
            // 로또 번호 ID 추출
            long lottoId = (Long) lotto.get("ID");
            // 로또 번호 비교를 위한 List 화
            List<Integer> numbers = new ArrayList<>();
            for (int i = 1; i <= 6; i++) {
                numbers.add((Integer) lotto.get("NUMBER_" + i));
            }

            // 로또 번호 맞은 갯수
            int correctNumbers = countCorrect(lottoNumbers, numbers);

            // 로또 등수
            int rank = lottoRank(correctNumbers);

            if (rank > 0) {
                lottoMapper.createWinner(lottoId, rank);
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
