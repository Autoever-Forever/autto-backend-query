package ottua.queryservice.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
public enum ErrorResponseStatus {
    // 아래는 예시
    BAD_REQUEST_INVALID_OPTION(BAD_REQUEST, "유효하지 않은 옵션입니다."),
    NOT_FOUND_PRODUCT_ID(NOT_FOUND, "없는 공연 ID 입니다."),
    ;

    private final HttpStatus httpStatus;
    private final String message;
}
