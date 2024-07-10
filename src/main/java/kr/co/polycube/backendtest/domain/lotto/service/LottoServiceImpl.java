package kr.co.polycube.backendtest.domain.lotto.service;

import kr.co.polycube.backendtest.domain.lotto.dao.LottoDao;
import kr.co.polycube.backendtest.domain.lotto.dao.LottoMapper;
import kr.co.polycube.backendtest.domain.lotto.dto.Lotto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Lotto 서비스 구현체
 *
 * @author 김종원
 * @version 1.0
 * @since 24. 7. 9. (화)
 */
@RequiredArgsConstructor
@Service
public class LottoServiceImpl implements LottoService {

    private final LottoDao lottoDao;
    private final LottoMapper lottoMapper;

    /**
     * Lotto 당첨 번호 생성 구현 메소드
     *
     * @return Lotto 객체
     */
    @Override
    public Lotto generateLotto() {
        return lottoDao.generateNumbers();
    }

    /**
     * 생성된 전체 Lotto 조회 구현 메소드
     *
     * @return 조회된 Lotto 번호 리스트
     */
    @Override
    public List<Lotto> getLottoAll() {
        List<Lotto> lottoList = new ArrayList<>();
        List<Map<String, Object>> lottoTable = lottoMapper.readAll();

        for (Map<String, Object> lottoMap : lottoTable) {
            Lotto lotto = new Lotto();
            // 로또 번호 ID 추출
            lotto.setId((Long) lottoMap.get("ID"));
            // 로또 번호 추출
            List<Integer> numbers = new ArrayList<>();
            for (int i = 1; i <= 6; i++) {
                numbers.add((Integer) lottoMap.get("NUMBER_" + i));
            }
            lotto.setNumbers(numbers);
            // 로또 객체에 요소 담기
            lottoList.add(lotto);
        }
        
        return lottoList;
    }

    /**
     * 특정 ID로 로또 조회 구현 메소드
     *
     * @param id 조회할 ID
     * @return 조회된 Lotto 번호
     */
    @Override
    public Lotto getLottoById(long id) {
        Lotto lotto = new Lotto();
        Map<String, Object> lottoMap = lottoMapper.readById(id);
        // 로또 번호 ID 추출
        lotto.setId((Long) lottoMap.get("ID"));
        // 로또 번호 추출
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            numbers.add((Integer) lottoMap.get("NUMBER_" + i));
        }
        lotto.setNumbers(numbers);

        return lotto;
    }
}
