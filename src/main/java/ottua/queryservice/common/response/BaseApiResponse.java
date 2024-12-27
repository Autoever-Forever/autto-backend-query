package ottua.queryservice.common.response;

import lombok.Getter;

@Getter
public class BaseApiResponse<T> {
    private Integer status;
    private String message;
    private T data;

    public BaseApiResponse(Integer status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
