package kr.co.polycube.backendtest.domain.lotto.dao;

import kr.co.polycube.backendtest.domain.lotto.dto.Lotto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Lotto DAO
 *
 * @author 김종원
 * @version 1.0
 * @since 24. 7. 9. (화)
 */
@Repository
public class LottoDao {

    /**
     * Lotto 당첨 번호 생성
     * 
     * @return 생성된 Lotto 객체
     */
    public Lotto generateNumbers() {
        Lotto lotto = new Lotto();
        List<Integer> lottoNumbers = new ArrayList<>();
        Random random = new Random();

        while (lottoNumbers.size() < 6) {
            int num = random.nextInt(45) + 1;

            if (!lottoNumbers.contains(num)) {
                lottoNumbers.add(num);
            }
        }

        lotto.setNumbers(lottoNumbers);

        return lotto;
    }

}
