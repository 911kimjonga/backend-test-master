package kr.co.polycube.backendtest.web.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 오류 코드, 메세지 객체
 * 
 * @author 김종원
 * @version 1.0
 * @since 24. 7. 8. (월)
 */
@Data
@AllArgsConstructor
public class ErrorResult {

    private String code;
    private String message;

}
