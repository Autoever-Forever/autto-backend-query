package ottua.queryservice.reservation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Getter
public class ReservationDto {
    @JsonProperty("id")
    private String reservationId;
    @JsonProperty("seatId")
    private String seatId;
    @JsonProperty("created_date")
    private LocalDateTime createdDate;
    @JsonProperty("status")
    private String status;
}
