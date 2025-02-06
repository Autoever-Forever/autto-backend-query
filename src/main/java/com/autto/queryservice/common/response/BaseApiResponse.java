package com.autto.queryservice.common.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BaseApiResponse<T> {
    private final Integer status;
    private final String message;
    private final T data;

    public BaseApiResponse(HttpStatus status, String message, T data) {
        this.status = status.value();
        this.message = message;
        this.data = data;
    }

    public static <T> BaseApiResponse<T> success(String message, T data) {
        return new BaseApiResponse<>(HttpStatus.OK, message, data);
    }

    public static BaseApiResponse<Void> error(HttpStatus status, String message) {
        return new BaseApiResponse<>(status, message, null);
    }
}
