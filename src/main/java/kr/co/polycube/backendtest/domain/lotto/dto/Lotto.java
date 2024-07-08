package kr.co.polycube.backendtest.domain.lotto.dto;

import lombok.*;

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

    private int id;
    private int number1;
    private int number2;
    private int number3;
    private int number4;
    private int number5;
    private int number6;

}
