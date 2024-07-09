package kr.co.polycube.backendtest.domain.lotto.dto;

import lombok.*;

import java.util.List;

/**
 * Lotto DTO
 *
 * @author 김종원
 * @version 1.0
 * @since 24. 7. 8. (월)
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Lotto {

    private List<Integer> numbers;

}
