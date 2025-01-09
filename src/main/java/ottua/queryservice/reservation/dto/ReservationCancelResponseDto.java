package ottua.queryservice.reservation.dto;

import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@Getter
public class ReservationCancelResponseDto {
    private int status;
    private String message;
    private String error;
    private ReservationCancelDto data;
}
