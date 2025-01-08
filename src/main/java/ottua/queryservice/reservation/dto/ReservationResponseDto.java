package ottua.queryservice.reservation.dto;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Getter
public class ReservationResponseDto {
    private int status;
    private String message;
    private String error;
    private List<ReservationDto> data;
}
