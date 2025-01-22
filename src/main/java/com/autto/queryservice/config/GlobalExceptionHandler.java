package com.autto.queryservice.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.autto.queryservice.common.response.BaseApiResponse;
import com.autto.queryservice.common.response.CustomException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {IllegalArgumentException.class})
    public BaseApiResponse<Void> handleIllegalArgumentException(IllegalArgumentException e) {
        return BaseApiResponse.error(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    @ExceptionHandler(value = {CustomException.class})
    public BaseApiResponse<Void> handleCustomException(CustomException e) {
        return BaseApiResponse.error(e.getErrorResponseStatus().getHttpStatus(), e.getMessage());
    }

    @ExceptionHandler(value = {Exception.class})
    public BaseApiResponse<Void> handleException(Exception e) {
        return BaseApiResponse.error(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }
}
