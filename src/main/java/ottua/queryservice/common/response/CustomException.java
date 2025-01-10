package ottua.queryservice.common.response;

import lombok.*;

@Getter
public class CustomException extends RuntimeException {
    private final ErrorResponseStatus errorResponseStatus;

    public CustomException(ErrorResponseStatus errorResponseStatus) {
        super(errorResponseStatus.getMessage());
        this.errorResponseStatus = errorResponseStatus;
    }
}
