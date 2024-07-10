package kr.co.polycube.backendtest.domain.winner.dto;

import lombok.*;

/**
 * Winner DTO
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
public class Winner {

    private long id;
    private long lottoId;
    private int rank;

}
