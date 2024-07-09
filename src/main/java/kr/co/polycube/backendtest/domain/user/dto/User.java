package kr.co.polycube.backendtest.domain.user.dto;

import lombok.*;

/**
 * User DTO
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
public class User {

    private long id;
    private String name;

}
