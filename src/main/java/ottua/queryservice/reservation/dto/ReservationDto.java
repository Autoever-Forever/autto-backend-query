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
    private UUID reservationId;
    @JsonProperty("productId")
    private UUID productId;
    @JsonProperty("userId")
    private UUID userId;
    @JsonProperty("created_date")
    private LocalDateTime createdDate;
    @JsonProperty("last_update")
    private LocalDateTime updatedDate;
    @JsonProperty("ticket_date")
    private LocalDateTime ticketDate;
    @JsonProperty("status")
    private String status;
}
