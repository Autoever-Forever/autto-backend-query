package ottua.queryservice.reservation.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class MyReservationDto {
    private UUID reservationId;
    private UUID productId;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private LocalDateTime ticketDate;
    private String status;
    private String title;

    public MyReservationDto(ReservationDto reservation, String title) {
        this.reservationId = reservation.getReservationId();
        this.productId = reservation.getProductId();
        this.createdDate = reservation.getCreatedDate();
        this.updatedDate = reservation.getUpdatedDate();
        this.ticketDate = reservation.getUpdatedDate();
        this.status = reservation.getStatus();
        this.title = title;
    }
}

