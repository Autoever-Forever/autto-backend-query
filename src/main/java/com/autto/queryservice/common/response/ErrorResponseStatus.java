package com.autto.queryservice.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
public enum ErrorResponseStatus {
    // NOT_FOUND 에러
    NOT_FOUND_PRODUCT_ID(NOT_FOUND, "없는 공연입니다."),
    NOT_FOUND_SEAT_ID(NOT_FOUND, "없는 좌석입니다."),
    NOT_FOUNT_RESERVATION(NOT_FOUND, "없는 예약 내역입니다."),

    //

    // JWT 토큰 에러
    UNKNOWN_ERROR(UNAUTHORIZED, "알 수 없는 토큰 에러"),
    WRONG_TYPE_TOKEN(UNAUTHORIZED, "유효하지 않은 토큰입니다."),
    EXPIRED_TOKEN(UNAUTHORIZED, "토큰이 만료되었습니다"),
    UNSUPPORTED_TOKEN(UNAUTHORIZED, "지원하지 않는 토큰입니다."),
    ACCESS_DENIED(UNAUTHORIZED, "권한이 없습니다"),
    WRONG_SIGNATURE(UNAUTHORIZED, "유효하지 않은 토큰입니다")
    ;

    private final HttpStatus httpStatus;
    private final String message;
}
