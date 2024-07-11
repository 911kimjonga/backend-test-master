package kr.co.polycube.backendtest.web.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

/**
 * 예외처리 구현
 *
 * @author 김종원
 * @version 1.0
 * @since 24. 7. 8. (월)
 */
@RestControllerAdvice
@Slf4j
public class ControllerExceptionAdvice {

    /**
     * 잘못된 요청 시 예외 처리
     *
     * @param ex 예외 요소
     * @return 예외 메세지
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    public ErrorResult exception400Handle(HttpClientErrorException.BadRequest ex) {
        log.error("reason : {}", ex);
        return new ErrorResult("BAD-REQUEST", ex.getMessage());
    }

    /**
     * 존재하지 않는 API 호출 시 예외 처리
     *
     * @param ex 예외 요소
     * @return 예외 메세지
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ErrorResult exception404Handle(HttpClientErrorException.NotFound ex) {
        log.error("reason : {}", ex);
        return new ErrorResult("NOT-FOUND", ex.getMessage());
    }

    /**
     * 서버 오류 시 예외 처리
     *
     * @param ex 예외 요소
     * @return 예외 메세지
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(HttpServerErrorException.InternalServerError.class)
    public ErrorResult exception5xxHandle(HttpServerErrorException.InternalServerError ex) {
        log.error("reason : {}", ex);
        return new ErrorResult("INTERNAL_SERVER_ERROR", ex.getMessage());
    }

}
